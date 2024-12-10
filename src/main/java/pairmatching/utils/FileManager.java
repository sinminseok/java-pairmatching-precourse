package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {

    private static final String ROOT_FILE_PATH = "src/main/resources/";

    public FileManager() {
    }

    public static List<String> readFile(final String fileName) {
        File file = new File(ROOT_FILE_PATH + fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
