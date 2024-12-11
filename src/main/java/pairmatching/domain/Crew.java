package pairmatching.domain;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(final Course course, final String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
