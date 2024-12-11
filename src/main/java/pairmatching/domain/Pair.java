package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> crews;

    public Pair(final List<Crew> crews) {
        this.crews = crews;
    }

    public List<String> getCrewNames(){
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
