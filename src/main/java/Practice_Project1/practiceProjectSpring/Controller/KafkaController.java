//step 2

package Practice_Project1.practiceProjectSpring.Controller;

import Practice_Project1.practiceProjectSpring.Producer.EmployeeKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor

public class KafkaController {

    private final EmployeeKafkaProducer employeeKafkaProducer;

    @PostMapping("/kafkaSend")
    public String sendMessage(@RequestParam String message) {

        employeeKafkaProducer.sendMessage(message);

        return "Message sent successfully";
    }
}