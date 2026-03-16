package com.example.jpa1.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class BillingInfo {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    @Embedded
    private Address billingAddress;
}
