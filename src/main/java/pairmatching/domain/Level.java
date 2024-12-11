package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차 경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private String name;
    private List<String> missions;

    Level(final String name, final List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level valueOfName(String name){
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레벨입니다."));
    }


}