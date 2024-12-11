package pairmatching.constants;

import pairmatching.utils.CustomException;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessage.ERROR_FUNCTION_OPTION;

public enum FunctionOption {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    QUIT("Q");

    private final String command;

    FunctionOption(String command) {
        this.command = command;
    }

    public static FunctionOption valueOfCommand(String command){
        return Arrays.stream(values())
                .filter(option -> option.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new CustomException(ERROR_FUNCTION_OPTION));
    }

    public boolean isOne(){
        return this == ONE;
    }

    public boolean isTWO(){
        return this == TWO;
    }

    public boolean isThree(){
        return this == THREE;
    }

    public boolean isQuit(){
        return this == QUIT;
    }
}
