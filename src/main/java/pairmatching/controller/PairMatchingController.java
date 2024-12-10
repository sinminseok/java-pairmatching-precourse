package pairmatching.controller;

import pairmatching.constants.FunctionOption;
import pairmatching.service.FileService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {
    private final FileService fileService;

    public PairMatchingController(FileService fileService) {
        this.fileService = fileService;
    }

    public void run(){
        FunctionOption functionOption = InputView.inputFunction();
        OutputView.printMatchingInformation();

        List<String> names = InputView.inputMatchingInformation();
    }
}
