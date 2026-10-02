//package Practice_Project1.practiceProjectSpring.Producer;
//
//public class EmployeeKafkaProducer {
//}


package Practice_Project1.practiceProjectSpring.Producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "employee-events";

    public void sendMessage(String message) {

        kafkaTemplate.send(TOPIC, message);

        System.out.println("Message sent to Kafka: " + message);
    }
}