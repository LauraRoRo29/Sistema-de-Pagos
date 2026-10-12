package com.payments.entities;

import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;

public class BankTransferPayment extends Payment {

    // Atributos de transferencia bancaria
    private String accountNumber;
    private String bank;
    private double availableBalance;

    // Constructor
    public BankTransferPayment(String id, double amount, String accountNumber, String bank, double availableBalance) throws InvalidPaymentException {

        // Atributos comunes
        super(id, amount);

        // Inicia atributos de transferencia
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.availableBalance = availableBalance;
    }//constructor

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }//getAccountNumber

    public String getBank() {
        return bank;
    }//getBank

    public double getAvailableBalance() {
        return availableBalance;
    }//getAvailableBalance

    // Setter del saldo
    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }//setAvailableBalance

    // Metodo para transferencia bancaria
    @Override
    public void processPayment() throws InsufficientFundsException, InvalidPaymentException {

        // Verifica datos obligatorios
        if (accountNumber == null || accountNumber.isEmpty()) {
            setStatus(PaymentStatus.REJECTED);

            throw new InvalidPaymentException("Transferencia rechazada. El número de cuenta no es válido.");

        } else if (bank == null || bank.isEmpty()) {
            setStatus(PaymentStatus.REJECTED);

            throw new InvalidPaymentException("Transferencia rechazada. El banco no es válido.");

        } else if (availableBalance >= getAmount()) {
            availableBalance = availableBalance - getAmount();

            setStatus(PaymentStatus.APPROVED);

            System.out.println("Transferencia aprobada.");
            System.out.println("Banco: " + bank);
            System.out.println("Cuenta: " + accountNumber);
            System.out.println("Monto transferido: $" + getAmount());
            System.out.println("Saldo restante: $" + availableBalance);

        } else {
            setStatus(PaymentStatus.REJECTED);

            throw new InsufficientFundsException("Transferencia rechazada. Saldo disponible insuficiente.");
        }
    }//processPayment

    @Override
    public String toString() {
        return super.toString() + " [Banco: " + bank + " | Cuenta: " + accountNumber + " | Saldo: $" + availableBalance + "]";
    }//toString
}//class BankTransferPayment
