package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.utils.FileManager;

import java.util.List;

public class FileService {
    private static final String BACK_END_FILE_NAME = "backend-crew.md";
    private static final String FRONT_END_FILE_NAME = "frontend-crew.md";

    public List<String> readCrewNames(Course course){
        if(course.isBackEnd()){
            return FileManager.readFile(BACK_END_FILE_NAME);
        }
        return FileManager.readFile(FRONT_END_FILE_NAME);
    }
}
