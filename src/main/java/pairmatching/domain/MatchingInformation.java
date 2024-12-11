package pairmatching.domain;

public class MatchingInformation {
    private final Level level;
    private final Course course;
    private final Mission mission;

    private MatchingInformation(final Level level, final Course course, final Mission mission) {
        this.level = level;
        this.course = course;
        this.mission = mission;
    }

    public static MatchingInformation of(final Level level, final Course course, final Mission mission) {
        return new MatchingInformation(level, course, mission);
    }
}
