package com.example.jpaproject.embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BillingInfo {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    private Address billingAddress;
}
