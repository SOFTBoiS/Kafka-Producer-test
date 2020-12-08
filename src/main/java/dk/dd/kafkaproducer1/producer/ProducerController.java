package dk.dd.kafkaproducer1.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController
{
      @Autowired
      private ProducerService service;

      @PostMapping("/message/")
      public String sendMyMessageToKafka()
      {
            service.sendCycles();

            return "Message published";
      }
}
