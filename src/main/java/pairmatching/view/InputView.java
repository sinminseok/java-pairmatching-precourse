package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.FunctionOption;

import static pairmatching.constants.ViewMessage.SELECT_FUNCTION_MESSAGE;

public class InputView {

    private InputView(){
    }

    public static FunctionOption inputFunction(){
        System.out.println(SELECT_FUNCTION_MESSAGE);
        String input = Console.readLine();
        return FunctionOption.valueOfCommand(input);
    }
}
