package com.example.jpaproject.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class BillingInfo {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    @Embedded
    private Address billingAddress;
}
