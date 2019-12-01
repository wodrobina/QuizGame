package user;

import question.QuestionFacade;

import java.util.Set;
import java.util.stream.Collectors;

public class UserFacade {

    private final QuestionFacade questionFacade;

    public UserFacade(QuestionFacade questionFacade) {
        this.questionFacade = questionFacade;
    }

    public User registerUserIntoGame(NewUserDto newUser) {
        final User user = new User(newUser);
        user.assignChallenges(provideChallengesToNewUser(newUser));
        return user;
    }

    private Set<UserChallange> provideChallengesToNewUser(NewUserDto newUser) {
        return questionFacade.provideChallengesToNewUser(newUser).stream()
                .map(providedChallenge -> new UserChallange(providedChallenge.getQuestionText(),
                        providedChallenge.getPossibleAnswers()))
                .collect(Collectors.toSet());
    }
}
