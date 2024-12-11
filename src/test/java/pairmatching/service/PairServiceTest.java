package pairmatching.service;

import org.junit.jupiter.api.Test;
import pairmatching.domain.PairGroup;
import pairmatching.dto.MatchInformationRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PairServiceTest {

    private final PairService pairService = new PairService();

    @Test
    void 크루_이름이_홀수_일때_매칭_기능_테스트() {
        //given
        MatchInformationRequest matchInformationRequest = new MatchInformationRequest("백엔드", "레벨1", "로또");
        List<String> crewNames = List.of("크루1", "크루2", "크루3", "크루4", "크루5", "크루6", "크루7");
        PairGroup pairGroup = pairService.matchPair(matchInformationRequest, crewNames);
        List<List<String>> pairCrewNames = pairGroup.getPairCrewNames();

        assertThat(pairCrewNames.size()).isEqualTo(3);
        assertThat(pairCrewNames.get(2).size()).isEqualTo(3);
    }

    @Test
    void 크루_이름이_짝수_일때_매칭_기능_테스트() {
        //given
        MatchInformationRequest matchInformationRequest = new MatchInformationRequest("백엔드", "레벨1", "로또");
        List<String> crewNames = List.of("크루1", "크루2", "크루3", "크루4", "크루5", "크루6");
        PairGroup pairGroup = pairService.matchPair(matchInformationRequest, crewNames);
        List<List<String>> pairCrewNames = pairGroup.getPairCrewNames();

        assertThat(pairCrewNames.size()).isEqualTo(3);
        assertThat(pairCrewNames.get(2).size()).isEqualTo(2);
    }
}
