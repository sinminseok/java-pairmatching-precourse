package pairmatching.controller;

import pairmatching.constants.FunctionOption;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {

    public void run(){
        FunctionOption functionOption = InputView.inputFunction();
        OutputView.printMatchingInformation();

        List<String> names = InputView.inputMatchingInformation();
    }
}
