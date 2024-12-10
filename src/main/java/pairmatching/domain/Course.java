package pairmatching.domain;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(final String name) {
        this.name = name;
    }

    public boolean isBackEnd(){
        return this == BACKEND;
    }
}