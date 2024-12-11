package pairmatching.domain;

import pairmatching.utils.CustomException;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessage.ERROR_LEVEL_NAME;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(final String name) {
        this.name = name;
    }

    public static Level valueOfName(String name){
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new CustomException(ERROR_LEVEL_NAME));
    }

    public boolean isSameLevel(Level compareLevel){
        return this == compareLevel;
    }
}