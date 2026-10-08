package com.payments.entities;

public abstract class Payment {

    // Atributos de la clase
    private long id;
    private double amount;
    private String status;

    //Constructor
    public Payment(long id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }//constructor Payment

    //Getters
    public long getId() {
        return id;
    }//getId

    public double getAmount() {
        return amount;
    }//getAmount

    //Getters y Setters para el estado
    public String getStatus() {
        return status;
    }//getStatus

    public void setStatus(String status) {
        this.status = status;
    }//setStatus

    public abstract void processPayment();


}// class Payment
