package dk.dd.kafkaproducer1;

import dk.dd.kafkaproducer1.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KafkaProducer1Application
{

public static void main(String[] args)
{
    SpringApplication.run(KafkaProducer1Application.class, args);

}
}


