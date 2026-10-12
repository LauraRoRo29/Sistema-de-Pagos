package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public class PayPalPayment extends Payment {

    // Atributos de PayPal
    private String email;
    private double availableBalance;

    // Constructor
    public PayPalPayment(String id, double amount, String email, double availableBalance) throws InvalidPaymentException {

        // Atributos comunes
        super(id, amount);

        // Inicia  atributos de PayPal
        this.email = email;
        this.availableBalance = availableBalance;
    }// constructor

    // Getters
    public String getEmail() {
        return email;
    }//getEmail

    public double getAvailableBalance() {
        return availableBalance;
    }//getAvailableBalance

    // Setter para availableBalance
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }//setAvailableBalance

    // Metodo para PayPal
    @Override
    public void processPayment() throws InsufficientFundsException, InvalidPaymentException {

        // Valida que el correo no esté vacío y que tenga @
        if (email == null || email.isEmpty() || !email.contains("@")) {
            setStatus(PaymentStatus.REJECTED);

            throw new InvalidPaymentException("Pago PayPal rechazado. El correo electrónico no es válido.");

        } else if (availableBalance >= getAmount()) {
            availableBalance = availableBalance - getAmount();

            setStatus(PaymentStatus.APPROVED);

            System.out.println("Pago PayPal aprobado.");
            System.out.println("Correo: " + email);
            System.out.println("Monto pagado: $" + getAmount());
            System.out.println("Saldo restante: $" + availableBalance);

        } else {
            setStatus(PaymentStatus.REJECTED);

            throw new InsufficientFundsException("Pago PayPal rechazado. Saldo disponible insuficiente.");
        }
    }//processPayment

    @Override
    public String toString() {
        return super.toString() + " [PayPal: " + email + " | Saldo: $" + availableBalance + "]";
    }// toString
} //class PayPalPayment
