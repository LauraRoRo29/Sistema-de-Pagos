package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public abstract class Payment {
    private String id;
    private double amount;
    private PaymentStatus status;

    public Payment(String id, double amount) throws InvalidPaymentException {
        if (amount <= 0) {
            throw new InvalidPaymentException("El monto del pago debe ser mayor a 0.");
        }
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidPaymentException("El ID del pago no puede estar vacío.");
        }
        this.id = id;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public abstract void processPayment() throws InsufficientFundsException, InvalidPaymentException;

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    protected void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Pago [ID: %s | Monto: $%.2f | Estado: %s]", id, amount, status.getDescription());
    }
}
