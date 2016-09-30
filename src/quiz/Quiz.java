package quiz;

import javafx.util.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;

class Quiz {
    private static String title;
    private static ArrayList<Question> questions;

    /**
     * Getter for the title of the quiz
     * @return The title of the quiz
     */
    public static String getTitle() {
        return title;
    }

    /**
     * Setter for the title of the quiz
     * @param title The title of the quiz
     */
    public static void setTitle(String title) {
        Quiz.title = title;
    }

    /**
     * Getter for Questions
     * Shuffles the list of questions before returning it
     * @return The shuffled list of Question objects
     */
    static ArrayList<Question> getQuestions() {
        Collections.shuffle(questions);
        return questions;
    }

    /**
     * Setter for Questions
     * @param questions The list of Question objects
     */
    public static void setQuestions(ArrayList<Question> questions) {
        Quiz.questions = questions;
    }

    /**
     * Method to allow the user to set up a custom quiz.
     * Details to come.
     * TODO: Add custom quiz logic.
     */
    public static void SetUpCustomQuiz(){
        throw new NotImplementedException();
    }

    /**
     * The default setup method for the Capitals of the World quiz.
     * Adds 10 questions, each having four answer options.
     * Also sets the correct answers for each question.
     * If you want to set up the default quiz and play with it, just call this method.
     */
    public static void SetupDefaultQuiz(){
        questions = new ArrayList<>();
        title = "Capital Cities of the World!";
        Answers a = new Answers();
        a.addAnswer(new Pair<>("a","New Delhi"));
        a.addAnswer(new Pair<>("b","Jakarta"));
        a.addAnswer(new Pair<>("c","New York"));
        a.addAnswer(new Pair<>("d","Mumbai"));
        Question q = new Question("What is the capital of India?",a,"a");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Santiago"));
        a.addAnswer(new Pair<>("b","New York"));
        a.addAnswer(new Pair<>("c","Washington DC"));
        a.addAnswer(new Pair<>("d","Los Angeles"));
        q = new Question("What is the capital of the United States?",a,"c");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Busan"));
        a.addAnswer(new Pair<>("b","Jakarta"));
        a.addAnswer(new Pair<>("c","Pyongyang"));
        a.addAnswer(new Pair<>("d","Seoul"));
        q = new Question("What is the capital of South Korea?",a,"d");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Islamabad"));
        a.addAnswer(new Pair<>("b","Karachi"));
        a.addAnswer(new Pair<>("c","Lahore"));
        a.addAnswer(new Pair<>("d","Mumbai"));
        q = new Question("What is the capital of Pakistan?",a,"a");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Istanbul"));
        a.addAnswer(new Pair<>("b","Ankara"));
        a.addAnswer(new Pair<>("c","Damascus"));
        a.addAnswer(new Pair<>("d","Tehran"));
        q = new Question("What is the capital of Turkey?",a,"b");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Hong Kong"));
        a.addAnswer(new Pair<>("b","Beijing"));
        a.addAnswer(new Pair<>("c","Shanghai"));
        a.addAnswer(new Pair<>("d","Taiwan"));
        q = new Question("What is the capital of China?",a,"b");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Stuttgart"));
        a.addAnswer(new Pair<>("b","Bonn"));
        a.addAnswer(new Pair<>("c","Paris"));
        a.addAnswer(new Pair<>("d","Berlin"));
        q = new Question("What is the capital of Germany?",a,"d");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Nottingham"));
        a.addAnswer(new Pair<>("b","Stratford upon Avon"));
        a.addAnswer(new Pair<>("c","London"));
        a.addAnswer(new Pair<>("d","Dublin"));
        q = new Question("What is the capital of the United Kingdom?",a,"c");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Paris"));
        a.addAnswer(new Pair<>("b","Nice"));
        a.addAnswer(new Pair<>("c","Calias"));
        a.addAnswer(new Pair<>("d","London"));
        q = new Question("What is the capital of France?",a,"a");
        questions.add(q);
        a = new Answers();
        a.addAnswer(new Pair<>("a","Rio de Janeiro"));
        a.addAnswer(new Pair<>("b","Sao Paulo"));
        a.addAnswer(new Pair<>("c","Brasilia"));
        a.addAnswer(new Pair<>("d","Salvador"));
        q = new Question("What is the capital of Brazil?",a,"a");
        questions.add(q);
        Collections.shuffle(questions);
    }
}
