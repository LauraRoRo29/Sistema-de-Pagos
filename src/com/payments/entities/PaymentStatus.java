package com.payments.entities;

public enum PaymentStatus {
    PENDING("Pendiente"),
    APPROVED("Aprovado"),
    REJECTED("Rechazado"),
    REFUNDED("Reembolsado");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}