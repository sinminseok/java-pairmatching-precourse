package pairmatching.controller;

import pairmatching.constants.FunctionOption;
import pairmatching.domain.Course;
import pairmatching.dto.MatchInformationRequest;
import pairmatching.service.FileService;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {
    private final FileService fileService;
    private final PairService pairService;

    public PairMatchingController(FileService fileService, PairService pairService) {
        this.fileService = fileService;
        this.pairService = pairService;
    }


    public void run(){
        FunctionOption functionOption = InputView.inputFunction();
        OutputView.printMatchingInformation();

        MatchInformationRequest matchingInformation = InputView.inputMatchingInformation();
        List<String> names = fileService.readCrewNames(Course.valueOfName(matchingInformation.course()));

        pairService.matchPair(matchingInformation, names);

    }
}
