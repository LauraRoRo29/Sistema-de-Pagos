package com.payments.interfaces;
import com.payments.exceptions.InvalidPaymentException;

public interface Refundable {
        void refund(double amount) throws InvalidPaymentException;
}//interface
