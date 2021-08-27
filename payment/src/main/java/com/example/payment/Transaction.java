package com.example.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "transactions")
public class Transaction {
	private @Id @GeneratedValue long id;
    private @NotBlank String transactionid;
    private @NotBlank String userid ;
    private @NotBlank float value;
    private @NotNull boolean paymentstatus = false;
    public Transaction() {
    }
    public Transaction(@NotBlank String transactionid,@NotBlank String userid, @NotBlank float value) {
        this.transactionid=transactionid;
    	this.userid = userid;
        this.value = value;
        this.paymentstatus = true;
    }
    
    //getters
    public String gettransactionid() {
        return transactionid;
    }
    public String getuserid() {
        return userid;
    }
    public float getvalue() {
        return value;
    }
    public boolean getpaymentstatus() {
        return paymentstatus;
    }
    
    //setters

    public void settransaction_id(String transactionid) {
        this.transactionid = transactionid;
    }
    
    public void setuser_id(String userid) {
        this.userid = userid;
    }
   
    public void setvalue(float value) {
        this.value = value;
    }
    
    public void paymentstatus(boolean paymentstatus) {
        this.paymentstatus = paymentstatus;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transactionid +
                ", user_id='" + userid + '\'' +
                ", value='" + value + '\'' +
                ", payment_status=" + paymentstatus +
                '}';
    }
}