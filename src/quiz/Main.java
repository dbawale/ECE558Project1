package quiz;

public class Main {
    public static void main(String[] args){
        Quiz quiz = new Quiz();
        quiz.SetupDefaultQuiz();
        for (Question q :
                quiz.getQuestions()) {
            System.out.println(q.toString());
            System.out.println("Correct answer: " + q.getCorrectanswer());
        }
    }
}
