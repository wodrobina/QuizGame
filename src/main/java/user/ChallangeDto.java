package user;

import java.util.Set;
import java.util.stream.Collectors;

public class ChallangeDto {

    private final String questionText;
    private final Set<PossibleAnswer> possibleAnswers;

    public ChallangeDto(String questionText, Set<PossibleAnswer> possibleAnswers) {
        this.questionText = questionText;
        this.possibleAnswers = possibleAnswers;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public Set<ChallangePossibleAnswer> getPossibleAnswers() {
        return possibleAnswers.stream()
                .map(possibleAnswer -> new ChallangePossibleAnswer(possibleAnswer.getText()))
                .collect(Collectors.toSet());
    }
}
