package pairmatching.domain;

import pairmatching.utils.CustomException;

import java.util.Arrays;

import static pairmatching.utils.ErrorMessage.ERROR_COURSE_NAME;

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
                .orElseThrow(() -> new CustomException(ERROR_COURSE_NAME));
    }

    public boolean isBackEnd(){
        return this == BACKEND;
    }
}