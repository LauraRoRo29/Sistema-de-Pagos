package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;
import com.payments.interfaces.Refundable;

public class CreditCardPayment extends Payment implements Refundable {
    private String cardNumber;
    private String cardHolder;
    private double availableLimit;

    public CreditCardPayment(String id, double amount, String cardNumber, String cardHolder, double availableLimit)
            throws InvalidPaymentException {
        super(id, amount);

        if (cardNumber == null || cardNumber.length() < 16) {
            throw new InvalidPaymentException("El número de tarjeta debe tener al menos 16 dígitos.");
        }
        if (cardHolder == null || cardHolder.trim().isEmpty()) {
            throw new InvalidPaymentException("El nombre del titular no puede estar vacío.");
        }

        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.availableLimit = availableLimit;
    }

    @Override
    public void processPayment() throws InsufficientFundsException {
        if (getAmount() > availableLimit) {
            setStatus(PaymentStatus.REJECTED);
            throw new InsufficientFundsException(
                    String.format("Límite insuficiente en Tarjeta de Crédito. Límite disponible: $%.2f, Intentado: $%.2f",
                            availableLimit, getAmount())
            );
        }

        availableLimit -= getAmount();
        setStatus(PaymentStatus.APPROVED);
        System.out.println("-> Pago con Tarjeta de Crédito aprobado para: " + cardHolder);
    }

    @Override
    public void refund() throws InvalidPaymentException {
        if (getStatus() != PaymentStatus.APPROVED) {
            throw new InvalidPaymentException("Solo se pueden reembolsar pagos con estado APROBADO.");
        }

        availableLimit += getAmount();
        setStatus(PaymentStatus.REFUNDED);
        System.out.println("-> Reembolso de $" + getAmount() + " aplicado a la tarjeta de " + cardHolder);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Tarjeta: ****%s | Titular: %s | Límite Restante: $%.2f]",
                cardNumber.substring(cardNumber.length() - 4), cardHolder, availableLimit);
    }
}
