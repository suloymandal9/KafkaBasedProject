package Practice_Project1.practiceProjectSpring.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorResponse(int status ,
                            String message ,
                            LocalDateTime timeStamp )
{

}
