package pairmatching.utils;

public enum ErrorMessage {
    ERROR_FUNCTION_OPTION("존재하지 않는 기능 입니다."),
    ERROR_FAILED_MATCH("매칭에 실패 했습니다."),
    ERROR_FAILED_FIND_MATCH("매칭 이력이 없습니다."),
    ERROR_LEVEL_NAME("존재하지 않는 레벨 입니다."),
    ERROR_MISSION_NAME("존재하지 않는 미션 입니다."),
    ERROR_COURSE_NAME("존재하지 않는 코스 입니다.");

    private static final String PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
