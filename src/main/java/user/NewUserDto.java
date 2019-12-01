package user;

public class NewUserDto {

    private final String newUserName;

    public NewUserDto(String newUserName) {
        this.newUserName = newUserName;
    }

    public String getNewUserName() {
        return newUserName;
    }
}
