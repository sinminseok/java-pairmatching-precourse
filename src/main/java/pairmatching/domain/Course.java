package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(final String name) {
        this.name = name;
    }

    public static Course valueOfName(String name){
        return Arrays.stream(values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코스 정보 입니다."));
    }

    public boolean isBackEnd(){
        return this == BACKEND;
    }
}