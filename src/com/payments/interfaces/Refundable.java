package com.payments.interfaces;
import com.payments.exceptions.InvalidPaymentException;

public interface Refundable {
    void refund() throws InvalidPaymentException;
}//interface Refundable