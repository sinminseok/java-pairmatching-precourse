package pairmatching.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> crews;
    private final Level level;

    public Pair(final List<Crew> crews, final Level level) {
        this.crews = crews;
        this.level = level;
    }

    public static Pair ofMatchInformation(final List<String> crewNames, final Level level, final Course course){
        List<Crew> crews = crewNames.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
        return new Pair(crews, level);
    }

    public boolean canMatchPair(Pair newPair) {
        List<String> beforeCrewNames = newPair.getCrewNames();
        List<String> currentPairNames = this.getCrewNames();
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.addAll(beforeCrewNames);
        uniqueNames.addAll(currentPairNames);
        int requiredUniqueNames = beforeCrewNames.size() + currentPairNames.size() - 1;
        return level.isSameLevel(newPair.level) && uniqueNames.size() >= requiredUniqueNames;
    }

    public List<String> getCrewNames() {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
