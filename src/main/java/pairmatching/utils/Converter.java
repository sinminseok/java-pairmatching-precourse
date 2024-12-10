package pairmatching.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String DELIMITER = ",";

    public Converter() {
    }

    public static List<String> splitDelimiter(final String value) {
        return Arrays.stream(value.split(DELIMITER))
                .map(String::trim) // 각 요소의 앞뒤 공백 제거
                .toList();
    }
}
