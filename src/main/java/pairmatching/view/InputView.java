package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.FunctionOption;

import java.util.List;

import static pairmatching.constants.ViewMessage.INPUT_MATCHING_INFORMATION_MESSAGE;
import static pairmatching.constants.ViewMessage.SELECT_FUNCTION_MESSAGE;
import static pairmatching.utils.Converter.splitDelimiter;

public class InputView {

    private InputView(){
    }

    public static FunctionOption inputFunction(){
        System.out.println(SELECT_FUNCTION_MESSAGE);
        String input = Console.readLine();
        return FunctionOption.valueOfCommand(input);
    }

    public static List<String> inputMatchingInformation(){
        System.out.println(INPUT_MATCHING_INFORMATION_MESSAGE);
        String input = Console.readLine();
        return splitDelimiter(input);
    }
}
