package Practice_Project1.practiceProjectSpring.DTO;

import java.time.LocalDateTime;

public record EmployeeErrorResponse(int status,
                                    String message,
                                    LocalDateTime localDateTime) {
}
