package com.example.monwebetable.services;

import com.example.monwebetable.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address save(Address address);
    Optional<Address>findOne(Long id);
    Address upade(Address address);

    List<Address> findAll();

    void delete(Long id);

}
