package com.example.payment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyTopicConsumer {

    private final static List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "payment", groupId = "group_id")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }
    
    

    public static String getTransactionid(String userid) {
    	
    	String transactionid="";
    	System.out.println(messages);
    	List<String> matches = new ArrayList<String>();
    	 for(String str: messages) {
    	        if (str.contains(userid)) {
    	            matches.add(str);
    	        }
    	    }
    	 String json=matches.toString();
    	 try{
    	 JSONArray array = new JSONArray(json);  
    	 for(int i=0; i < array.length(); i++)   
    	 {  
    	 JSONObject object = array.getJSONObject(i);  
    	 transactionid=object.getString("transactionid");  
    	   
    	 } 
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return transactionid;
    	}

}