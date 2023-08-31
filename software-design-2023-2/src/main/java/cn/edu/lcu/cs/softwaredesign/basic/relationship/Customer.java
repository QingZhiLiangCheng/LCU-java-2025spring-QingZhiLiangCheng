package cn.edu.lcu.cs.softwaredesign.basic.relationship;

import java.util.List;

public class Customer {
    private Address address;

    private List<Product> products;

    public Address getAddress() {
        return address;
    }
    public List<Product> getProducts() {
        return products;
    }
}
