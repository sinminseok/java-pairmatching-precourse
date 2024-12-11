package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PairGroup {
    private final List<Pair> pairs;
    private final MatchingInformation matchingInformation;

    public PairGroup(final List<Pair> pairs, final MatchingInformation matchingInformation) {
        this.pairs = pairs;
        this.matchingInformation = matchingInformation;
    }

    public boolean isAlreadyMatch(Pair newPair) {
        for(Pair pair : pairs){
            if(!pair.canMatchPair(newPair)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> getPairCrewNames(){
        return pairs.stream()
                .map(Pair::getCrewNames)
                .collect(Collectors.toList());
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
