package question;

import java.util.Set;

class Question {

    private final Set<Answer> answers;
    private final Answer correctAnswer;

    public Question(Set<Answer> answers, Answer correctAnswer) {
        this.answers = Set.copyOf(answers);
        this.correctAnswer = correctAnswer;
    }
}
