package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.service.FileService;

public class Application {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        PairMatchingController pairMatchingController = new PairMatchingController(fileService);
        pairMatchingController.run();
    }
}
