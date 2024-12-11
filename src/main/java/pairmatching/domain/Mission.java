package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    CAR_RACE("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVE("성능개선"),
    DISTRIBUTION("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission valueOfName(String name){
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
    }
}
