package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> crews;
    private final Level level;

    public Pair(final List<Crew> crews, final Level level) {
        this.crews = crews;
        this.level = level;
    }

    public List<String> getCrewNames(){
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
