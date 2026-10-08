package com.payments;

import com.payments.entities.*;
import com.payments.exceptions.InsufficientFundsException;
import com.payments.exceptions.InvalidPaymentException;
import com.payments.interfaces.Refundable;

public class PaymentsApp {

    public static void main(String[] args) {
        PaymentManager manager = new PaymentManager();

        // 1. Crear diferentes métodos de pago (datos ficticios)
        Payment p1 = new CreditCardPayment("P001", 1000.0, "4111-0000-0000-1111", "Ana López", 5000.0);
        Payment p2 = new PayPalPayment("P002", 300.0, "cliente@correo.com", 800.0);
        Payment p3 = new BankTransferPayment("P003", 2000.0, "0011223344", "Banco Ficticio", 500.0); // fallará
        Payment p4 = new CreditCardPayment("P004", 1000.0, "4222-0000-0000-2222", "Luis Pérez", 500.0); // fallará

        Payment[] pagos = {p1, p2, p3, p4};

        // 2. Procesar pagos (exitosos y fallidos) y registrarlos
        for (Payment pago : pagos) {
            procesarYRegistrar(manager, pago);
        }

        // 3. Mostrar los pagos registrados
        System.out.println();
        manager.showPayments();

        // 4. Buscar un pago por ID
        System.out.println("\n===== BÚSQUEDA =====");
        Payment encontrado = manager.findById("P002");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        } else {
            System.out.println("No se encontró el pago.");
        }
        System.out.println("Buscar P999: " + (manager.findById("P999") == null ? "no existe" : "existe"));

        // 5. Realizar un reembolso
        System.out.println("\n===== REEMBOLSO =====");
        Payment aReembolsar = manager.findById("P001");
        if (aReembolsar instanceof Refundable) {
            ((Refundable) aReembolsar).refund();
            System.out.println("Reembolso realizado para " + aReembolsar.getId());
        } else {
            System.out.println("Este método de pago no permite reembolsos.");
        }

        // 6. Total procesado
        System.out.println("\n===== RESUMEN =====");
        System.out.println("Pagos registrados: " + manager.getPaymentCount());
        System.out.println("Total aprobado: $" + manager.getTotalProcessed());
    }

    private static void procesarYRegistrar(PaymentManager manager, Payment pago) {
        try {
            pago.processPayment();
            System.out.println("Pago " + pago.getId() + " APROBADO");
        } catch (InsufficientFundsException e) {
            System.out.println("Pago " + pago.getId() + " RECHAZADO: " + e.getMessage());
        } catch (InvalidPaymentException e) {
            System.out.println("Pago " + pago.getId() + " INVÁLIDO: " + e.getMessage());
        } finally {
            manager.registerPayment(pago); // se registra aunque sea rechazado, para ver su estado
        }
    }
}
