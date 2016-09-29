package quiz;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Answers a = new Answers();
        a.addAnswer(new Pair("a","answer1"));
        a.addAnswer(new Pair("b","answer2"));
        System.out.println(a.toString());
    }
}
