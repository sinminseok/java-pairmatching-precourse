package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.Ask;
import pairmatching.constants.FunctionOption;
import pairmatching.dto.MatchInformationRequest;

import java.util.List;

import static pairmatching.constants.ViewMessage.*;
import static pairmatching.utils.Converter.splitDelimiter;

public class InputView {

    private InputView(){
    }

    public static FunctionOption inputFunction(){
        System.out.println(SELECT_FUNCTION_MESSAGE);
        String input = Console.readLine();
        return FunctionOption.valueOfCommand(input);
    }

    public static MatchInformationRequest inputMatchingInformation(){
        System.out.println(INPUT_MATCHING_INFORMATION_MESSAGE);
        String input = Console.readLine();
        List<String> splits = splitDelimiter(input);
        return new MatchInformationRequest(splits.get(0), splits.get(1), splits.get(2));
    }

    public static Ask inputReMatch(){
        System.out.println(INPUT_REMATCH_MESSAGE);
        System.out.println(YES_OR_NO_MESSAGE);
        String input = Console.readLine();
        return Ask.valueOfCommand(input);
    }
}
