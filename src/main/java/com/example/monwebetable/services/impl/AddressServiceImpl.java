package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Address;
import com.example.monwebetable.repositories.AdressRepository;
import com.example.monwebetable.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public Optional<Address> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Address upade(Address address) {
        return null;
    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
