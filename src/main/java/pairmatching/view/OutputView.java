package pairmatching.view;

import java.util.List;

import static pairmatching.constants.ViewMessage.*;

public class OutputView {

    private OutputView(){
    }

    public static void printMatchingInformation(){
        System.out.println(DIVISION);
        System.out.println(COURSE);
        System.out.println(MISSION);
        System.out.println(DIVISION);
    }

    public static void printMatchingResult(List<List<String>> result){
        System.out.println(MATCHING_RESULT_MESSAGE);
        result.stream()
                .forEach(names -> printNames(names));
    }

    private static void printNames(List<String> names){
        String result = String.join(" : ", names);
        System.out.println(result);
    }
}
