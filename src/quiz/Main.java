package quiz;

public class Main {
    public static void main(String[] args){
        Quiz quiz = new Quiz();
        quiz.SetupDefaultQuiz();
        System.out.println(quiz.getSolution());
    }
}