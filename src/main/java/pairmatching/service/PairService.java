package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.*;
import pairmatching.dto.MatchInformationRequest;

import java.util.ArrayList;
import java.util.List;

public class PairService {

    public PairGroup matchPair(MatchInformationRequest matchInformationRequest, List<String> crewNames) {
        List<Pair> pairs = new ArrayList<>();
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        Course course = Course.valueOfName(matchInformationRequest.course());
        Level level = Level.valueOfName(matchInformationRequest.level());
        if (isOdd(shuffledCrew)) {
            matchOddCrews(level, course, shuffledCrew, pairs);
            return new PairGroup(pairs);
        }
        matchEvenCrews(level, course, shuffledCrew, pairs);
        return new PairGroup(pairs);
    }

    private void matchEvenCrews(Level level, Course course, List<String> crewNames, List<Pair> pairs) {
        for (int i = 0; i <= crewNames.size() - 2; i += 2) {
            Crew crew = new Crew(course, crewNames.get(i));
            Crew pairCrew = new Crew(course, crewNames.get(i + 1));
            pairs.add(new Pair(List.of(crew, pairCrew), level));
        }
    }

    private void matchOddCrews(Level level, Course course, List<String> crewNames, List<Pair> pairs) {
        for (int i = 0; i <= crewNames.size() - 3; i += 2) {
            if (i == crewNames.size() - 3) {
                Crew crew = new Crew(course, crewNames.get(i));
                Crew pairCrew = new Crew(course, crewNames.get(i + 1));
                Crew lastCrew = new Crew(course, crewNames.get(i + 2));
                pairs.add(new Pair(List.of(crew, pairCrew, lastCrew), level));
                break;
            }
            Crew crew = new Crew(course, crewNames.get(i));
            Crew pairCrew = new Crew(course, crewNames.get(i + 1));
            pairs.add(new Pair(List.of(crew, pairCrew), level));
        }
    }

    private boolean isOdd(List<String> values) {
        if (values.size() % 2 == 0) {
            return false;
        }
        return true;
    }

}
