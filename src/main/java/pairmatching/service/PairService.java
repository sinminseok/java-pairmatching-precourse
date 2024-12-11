package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.*;
import pairmatching.dto.MatchInformationRequest;
import pairmatching.utils.CustomException;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.utils.ErrorMessage.ERROR_FAILED_MATCH;

public class PairService {

    public List<PairGroup> pairGroups = new ArrayList<>();

    public PairGroup matchPair(MatchInformationRequest matchInformationRequest, List<String> crewNames) {
        PairGroup pairGroup = null;
        for (int i = 0; i <= 3; i++) {
            if (i == 3) {
                throw new CustomException(ERROR_FAILED_MATCH);
            }
            pairGroup = matchShufflePair(matchInformationRequest, crewNames);
            if (canMatch(pairGroup)) {
                break;
            }
        }
        return pairGroup;
    }

    private boolean canMatch(PairGroup newPairGroup) {
        for (PairGroup pairGroup : pairGroups) {
            List<Pair> pairs = pairGroup.getPairs();
            for (Pair pair : pairs) {
                if (newPairGroup.isAlreadyMatch(pair)) {
                    return false;
                }
            }
        }
        return true;
    }

    public PairGroup matchShufflePair(MatchInformationRequest matchInformationRequest, List<String> crewNames) {
        List<Pair> pairs = new ArrayList<>();
        Level level = findLevel(matchInformationRequest.level());
        Course course = findCourse(matchInformationRequest.course());
        Mission mission = findMission(matchInformationRequest.mission());
        List<String> shuffleNames = Randoms.shuffle(crewNames);
        if (isOdd(crewNames)) {
            matchOddCrews(level, course, shuffleNames, pairs);
        }
        if (!isOdd(crewNames)) {
            matchEvenCrews(level, course, shuffleNames, pairs);
        }
        MatchingInformation matchingInformation = MatchingInformation.of(level, course, mission);
        PairGroup pairGroup = new PairGroup(pairs, matchingInformation);
        pairGroups.add(pairGroup);
        return pairGroup;
    }

    private void matchEvenCrews(Level level, Course course, List<String> crewNames, List<Pair> pairs) {
        for (int i = 0; i <= crewNames.size() - 2; i += 2) {
            Pair pair = Pair.ofMatchInformation(List.of(crewNames.get(i), crewNames.get(i + 1)), level, course);
            pairs.add(pair);
        }
    }

    private void matchOddCrews(Level level, Course course, List<String> crewNames, List<Pair> pairs) {
        for (int i = 0; i <= crewNames.size() - 3; i += 2) {
            if (i == crewNames.size() - 3) {
                Pair pair = Pair.ofMatchInformation(List.of(crewNames.get(i), crewNames.get(i + 1), crewNames.get(i + 2)), level, course);
                pairs.add(pair);
                break;
            }
            Pair pair = Pair.ofMatchInformation(List.of(crewNames.get(i), crewNames.get(i + 1)), level, course);
            pairs.add(pair);
        }
    }


    private Level findLevel(String levelName) {
        return Level.valueOfName(levelName);
    }

    private Course findCourse(String courseName) {
        return Course.valueOfName(courseName);
    }

    private Mission findMission(String missionName){
        return Mission.valueOfName(missionName);
    }

    private boolean isOdd(List<String> values) {
        if (values.size() % 2 == 0) {
            return false;
        }
        return true;
    }

}
