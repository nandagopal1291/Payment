package com.example.payment;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	@Autowired
	TransactionRepository TransactionRepository;

	@PostMapping("/Transaction/add")
	public Status registerUser(@Valid @RequestBody Transaction newTransaction) {
		TransactionRepository.save(newTransaction);
		return Status.SUCCESS;
	}

	@GetMapping("/Transaction/all")
	public List<Transaction> getTransaction() {

		return TransactionRepository.findAll();

	}

	@GetMapping("/Transaction/{userid}")
	public String findById(@PathVariable("id") String userid) {
		String transid=MyTopicConsumer.getTransactionid(userid);
        Transaction mytransaction=new Transaction(transid,userid,4569);
        TransactionRepository.save(mytransaction);
        
		return GetProducts.getProducts(transid);
	}

	@GetMapping("/payment/{id}")
	public Status findById2(@PathVariable("id") String transactionid) {
           
		Transaction mytrans=TransactionRepository.findAllById(transactionid);
		mytrans.paymentstatus(true);
		return Status.SUCCESS;
	}


}