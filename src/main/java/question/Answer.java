package question;

class Answer {

    private final String text;

    public Answer(String text) {
        assert text != null;
        this.text = text;
    }

    public String getAnswersText() {
        return text;
    }

}
