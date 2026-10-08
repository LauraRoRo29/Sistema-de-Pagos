package com.payments.entities;

public class PayPalPayment extends Payment {

    // Atributos de PayPal
    private String email;
    private double availableBalance;

    // Constructor
    public PayPalPayment(long id, double amount, String status, String email, double availableBalance) {

        // Atributos comunes
        super(id, amount, status);

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
    public void processPayment() {

        // Valida que el correo no esté vacío
        if (email == null || email.isEmpty()) {
            setStatus("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("El correo electrónico no es válido.");

        } else if (getAmount() <= 0) {
            setStatus("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("El monto debe ser mayor que cero.");

        } else if (availableBalance >= getAmount()) {
            availableBalance = availableBalance - getAmount();

            setStatus("APPROVED");

            System.out.println("Pago PayPal aprobado.");
            System.out.println("Correo: " + email);
            System.out.println("Monto pagado: $" + getAmount());
            System.out.println("Saldo restante: $" + availableBalance);

        } else {
            setStatus("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("Saldo disponible insuficiente.");
        }
    }//processPayment

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "id=" + getId() +
                ", amount=$" + getAmount() +
                ", status='" + getStatus() + '\'' +
                ", email='" + email + '\'' +
                ", availableBalance=$" + availableBalance +
                '}';
    }// toString
} //class PayPalPayment