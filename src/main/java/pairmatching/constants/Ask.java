package pairmatching.constants;

import pairmatching.utils.CustomException;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessage.ERROR_ASK;
import static pairmatching.utils.ErrorMessage.ERROR_FUNCTION_OPTION;

public enum Ask {
    YES("예"),
    NO("아니요");

    private final String command;

    Ask(String command) {
        this.command = command;
    }

    public static Ask valueOfCommand(String command){
        return Arrays.stream(values())
                .filter(ask -> ask.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new CustomException(ERROR_ASK));
    }
}
