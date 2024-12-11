package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.service.FileService;
import pairmatching.service.PairService;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        PairService pairService = new PairService();
        PairMatchingController pairMatchingController = new PairMatchingController(fileService, pairService);
        pairMatchingController.run();
    }
}
