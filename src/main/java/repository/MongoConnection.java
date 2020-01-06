package repository;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.connection.ClusterSettings;
import configuration.AppProperties;

import java.util.Collections;
import java.util.List;

public class MongoConnection {

    private static MongoConnection INSTANCE;

    private MongoClient mongoClient;
    private MongoDatabase applicationDatabase;

    public static MongoConnection getInstance() {
        if (INSTANCE == null) {
            synchronized (MongoConnection.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MongoConnection();
                }
            }
        }
        return INSTANCE;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getApplicationDatabase() {
        return applicationDatabase;
    }

    private MongoConnection() {
        connect();
    }

    private void connect() {

        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .credential(applicationCredentials())
                .applyToClusterSettings(getBuilderBlock())
                .build();

        mongoClient = MongoClients.create(clientSettings);
        applicationDatabase = mongoClient.getDatabase(AppProperties.propertyOf("mongo.database"));
    }

    private static Block<ClusterSettings.Builder> getBuilderBlock() {
        return builder ->
                builder.hosts(applicationKnownHosts());
    }

    private static MongoCredential applicationCredentials() {
        return MongoCredential.createScramSha256Credential(
                AppProperties.propertyOf("mongo.user"),
                AppProperties.propertyOf("mongo.source"),
                AppProperties.propertyOf("mongo.user.password").toCharArray());
    }

    private static List<ServerAddress> applicationKnownHosts() {
        return Collections.singletonList(new ServerAddress(AppProperties.propertyOf("mongo.url"),
                Integer.parseInt(AppProperties.propertyOf("mongo.url.port"))));
    }
}
