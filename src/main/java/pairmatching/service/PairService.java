package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.dto.MatchInformationRequest;

import java.util.List;

public class PairService {

    public void matchPair(MatchInformationRequest matchInformationRequest, List<String> crewNames){
        List<String> shuffledCrew = Randoms.shuffle(crewNames);

    }
}
