package dk.dd.kafkaproducer1.producer;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerService
{
    private static final String TOPIC = "message-topic";
    private static Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private static Gson gson = new Gson();
    
    @Autowired
    // Ignore the compiler's warning
    private KafkaTemplate<String, String> template;
    
    public void sendMessage(String message)
    {
        template.send(TOPIC, message);
        // logger.info(String.format("### -> Producer sends message -> %s", message));
        logger.info("### Producer sends message [{}]", message);
        template.flush();
    }

    public void sendMessages(int iterations) {
        Order order = new Order();
        String json = gson.toJson(order);
        long time = System.nanoTime();
        String timeString = String.valueOf(time);

        while (iterations>0) {
            sendMessage(iterations + "," + timeString + "," + json);
            iterations--;
        }
    }

    public void sendCycles() {
        //test cycles of different message amounts
        List<Integer> cycles = new ArrayList<>(List.of(1, 10, 100, 1_000, 10_000, 100_000));

        //Run every cycle 10 times
        for (int cycle : cycles) {
            for (int i=10; i>0;i--) {
                sendMessages(cycle);
            }
        }

    }
}
