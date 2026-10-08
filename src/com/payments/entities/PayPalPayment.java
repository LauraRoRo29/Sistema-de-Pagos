package com.payments.entities;

public class PayPalPayment extends Payment {

    // Atributos de PayPal
    private String email;
    private double saldoDisponible;

    // Constructor
    public PayPalPayment(long id, double monto, String estado, String email, double saldoDisponible) {

        // Atributos comunes
        super(id, monto, estado);

        // Inicia  atributos propios de PayPal
        this.email = email;
        this.saldoDisponible = saldoDisponible;
    }// constructor

    // Getters
    public String getEmail() {
        return email;
    }//getEmail

    public double getSaldoDisponible() {
        return saldoDisponible;
    }//getSaldoDisponible

    // Setter para saldoDisponible
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }//setSaldoDisponible

    // Metodo para PayPal
    @Override
    public void processPayment() {

        // Valida que el correo no esté vacío
        if (email == null || email.isEmpty()) {
            setEstado("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("El correo electrónico no es válido.");

        } else if (getMonto() <= 0) {
            setEstado("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("El monto debe ser mayor que cero.");

        } else if (saldoDisponible >= getMonto()) {
            saldoDisponible = saldoDisponible - getMonto();

            setEstado("APPROVED");

            System.out.println("Pago PayPal aprobado.");
            System.out.println("Correo: " + email);
            System.out.println("Monto pagado: $" + getMonto());
            System.out.println("Saldo restante: $" + saldoDisponible);

        } else {
            setEstado("REJECTED");

            System.out.println("Pago PayPal rechazado.");
            System.out.println("Saldo disponible insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "id=" + getId() +
                ", monto=$" + getMonto() +
                ", estado='" + getEstado() + '\'' +
                ", email='" + email + '\'' +
                ", saldoDisponible=$" + saldoDisponible +
                '}';
    }// toStri
} //class PayPalPayment