package com.payments.entities;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager {

    private final List<Payment> payments = new ArrayList<>();

    // Registrar un pago
    public void registerPayment(Payment payment) {
        if (payment == null) {
            System.out.println("No se puede registrar un pago nulo.");
            return;
        }
        payments.add(payment);
        System.out.println("Pago registrado: " + payment.getId());
    }

    // Mostrar los pagos registrados
    public void showPayments() {
        if (payments.isEmpty()) {
            System.out.println("No hay pagos registrados.");
            return;
        }
        System.out.println("===== PAGOS REGISTRADOS =====");
        for (Payment payment : payments) {
            System.out.println(payment); // usa el toString() de cada subclase (polimorfismo)
        }
    }

    // Buscar un pago por ID
    public Payment findById(String id) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    // Total de dinero de los pagos aprobados
    public double getTotalProcessed() {
        double total = 0;
        for (Payment payment : payments) {
            if (payment.getStatus() == PaymentStatus.APPROVED) {
                total += payment.getAmount();
            }
        }
        return total;
    }

    // Cantidad de pagos registrados
    public int getPaymentCount() {
        return payments.size();
    }
}
