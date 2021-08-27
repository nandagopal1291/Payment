package com.example.payment;

import org.springframework.web.client.RestTemplate;

public class GetProducts {
	
	public static String getProducts(String transactionid)
	{
	    final String uri = "http:18.117.187.228//:8082/cart/"+transactionid;

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
	    return result;
	}

}
