package com.payments.entities;

public class BankTransferPayment extends Payment {

    // Atributos de transferencia bancaria
    private String numeroCuenta;
    private String banco;
    private double saldoDisponible;

    // Constructor
    public BankTransferPayment(long id, double monto, String estado, String numeroCuenta, String banco, double saldoDisponible) {

        // Atributos comunes
        super(id, monto, estado);

        // Inicializa atributos específicos de transferencia
        this.numeroCuenta = numeroCuenta;
        this.banco = banco;
        this.saldoDisponible = saldoDisponible;
    }//constructor

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }//getNumeroCuenta

    public String getBanco() {
        return banco;
    }//getBanco

    public double getSaldoDisponible() {
        return saldoDisponible;
    }//getSaldoDisponible

    // Setter del saldo
    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }//setSaldoDisponible

    // Metodo para transferencia bancaria
    @Override
    public void processPayment() {

        // Verifica datos obligatorios
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            setEstado("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El número de cuenta no es válido.");

        } else if (banco == null || banco.isEmpty()) {
            setEstado("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El banco no es válido.");

        } else if (getMonto() <= 0) {
            setEstado("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("El monto debe ser mayor que cero.");

        } else if (saldoDisponible >= getMonto()) {
            saldoDisponible = saldoDisponible - getMonto();

            setEstado("APPROVED");

            System.out.println("Transferencia aprobada.");
            System.out.println("Banco: " + banco);
            System.out.println("Cuenta: " + numeroCuenta);
            System.out.println("Monto transferido: $" + getMonto());
            System.out.println("Saldo restante: $" + saldoDisponible);

        } else {
            setEstado("REJECTED");

            System.out.println("Transferencia rechazada.");
            System.out.println("Saldo disponible insuficiente.");
        }
    }//processPayment

    @Override
    public String toString() {
        return "BankTransferPayment{" +
                "id=" + getId() +
                ", monto=$" + getMonto() +
                ", estado='" + getEstado() + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", banco='" + banco + '\'' +
                ", saldoDisponible=$" + saldoDisponible +
                '}';
    }//toString
}//class BankTransferPayment
