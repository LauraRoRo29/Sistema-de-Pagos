package com.payments.entities;

public class BankTransferPayment extends Payment {

    // Atributos de transferencia bancaria
    private String accountNumber;
    private String bank;
    private double availableBalance;

    // Constructor
    public BankTransferPayment(long id, double amount, String status, String accountNumber, String bank, double availableBalance) {

        // Atributos comunes
        super(id, amount, status);

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
    public void processPayment() {

        // Verifica datos obligatorios
        if (accountNumber == null || accountNumber.isEmpty()) {
            setStatus("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El número de cuenta no es válido.");

        } else if (bank == null || bank.isEmpty()) {
            setStatus("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El banco no es válido.");

        } else if (getAmount() <= 0) {
            setStatus("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El monto debe ser mayor que cero.");

        } else if (availableBalance >= getAmount()) {
            availableBalance = availableBalance - getAmount();

            setStatus("APPROVED");

            System.out.println("Transferencia aprobada.");
            System.out.println("Banco: " + bank);
            System.out.println("Cuenta: " + accountNumber);
            System.out.println("Monto transferido: $" + getAmount());
            System.out.println("Saldo restante: $" + availableBalance);

        } else {
            setStatus("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("Saldo disponible insuficiente.");
        }
    }//processPayment

    @Override
    public String toString() {
        return "BankTransferPayment{" +
                "id=" + getId() +
                ", amount=$" + getAmount() +
                ", status='" + getStatus() + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bank='" + bank + '\'' +
                ", availableBalance=$" + availableBalance +
                '}';
    }//toString
}//class BankTransferPayment