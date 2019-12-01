package user;

import java.util.Set;

class UserChallange {
    private final String challangeText;
    private final Set<ChallangePossibleAnswer> challangePossibleAnswers;
    private final boolean wasAnwered;

    public UserChallange(String challangeText, Set<ChallangePossibleAnswer> challangePossibleAnswers) {
        this.challangeText = challangeText;
        this.challangePossibleAnswers = challangePossibleAnswers;
        this.wasAnwered = false;
    }


}
