public class questions {

    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correct;

    public questions(){
        this.question = "";
        this.choiceA = "";
        this.choiceB = "";
        this.choiceC = "";
        this.choiceD = "";
        this.correct = "";
    }

    public questions(String question, String choiceA, String choiceB, String choiceC, String choiceD, String correct ){
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
