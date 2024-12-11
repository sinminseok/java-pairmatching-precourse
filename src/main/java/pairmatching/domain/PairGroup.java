package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PairGroup {
    private final List<Pair> pairs;

    public PairGroup(final List<Pair> pairs) {
        this.pairs = pairs;
    }

    public List<List<String>> getPairCrewNames(){
        return pairs.stream()
                .map(Pair::getCrewNames)
                .collect(Collectors.toList());
    }
}
