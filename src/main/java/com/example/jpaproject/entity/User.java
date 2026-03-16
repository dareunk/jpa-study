package com.example.jpaproject.entity;

import com.example.jpaproject.embedded.Address;
import com.example.jpaproject.embedded.BillingInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    private Address address;

    public void changeAddress(Address address) {
        this.address = address;
    }

    public User(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    private Address companyAddress;

    private List<BillingInfo> billingInfo = new ArrayList<>();

}
