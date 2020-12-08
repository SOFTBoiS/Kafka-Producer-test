package dk.dd.kafkaproducer1.producer;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;

public class Order{
    private int ID = 0;
    private int price = 100;
    private String status = "Sent";
    private String customer_id = "Adam";
    private List<Integer> item_id;

    public Order() {
        item_id = new ArrayList<Integer>();
        item_id.add(1);
        item_id.add(2);
        item_id.add(3);
        item_id.add(4);
    }

}