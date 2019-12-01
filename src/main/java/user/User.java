package user;

import java.util.Set;

class User {

    private final UserData userData;
    private Set<UserChallange> userChallenges;

    public User(NewUserDto newUser) {
        userData = new UserData(newUser.getNewUserName());
    }

    void assignChallenges(Set<UserChallange> userChallenges) {
        this.userChallenges = Set.copyOf(userChallenges);
    }
}
