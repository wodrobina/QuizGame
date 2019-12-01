package user;

import java.util.Set;

class User {

    private final UserData userData;
    private Set<UserChallange> userChallanges;

    public User(NewUserDto newUser) {
        userData = new UserData(newUser.getNewUserName());
    }

    void assignChallanges(Set<UserChallange> userChallanges) {
        this.userChallanges = Set.copyOf(userChallanges);
    }
}
