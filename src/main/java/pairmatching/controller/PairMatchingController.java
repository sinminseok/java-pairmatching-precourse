package pairmatching.controller;

import pairmatching.constants.FunctionOption;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    public void run(){
        FunctionOption functionOption = InputView.inputFunction();
        OutputView.printMatchingInformation();
    }
}
