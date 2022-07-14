package com.mabdoh.order.service.domain.valueobject;

import java.util.Objects;

public class StreetAddress {
    private final String street;
    private final String postCode;
    private final String city;


    public StreetAddress(String street, String postCode, String city) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
    }


    public String getStreet() {
        return this.street;
    }


    public String getPostCode() {
        return this.postCode;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StreetAddress)) {
            return false;
        }
        StreetAddress streetAddress = (StreetAddress) o;
        return Objects.equals(street, streetAddress.street) && Objects.equals(postCode, streetAddress.postCode) && Objects.equals(city, streetAddress.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postCode, city);
    }
}
