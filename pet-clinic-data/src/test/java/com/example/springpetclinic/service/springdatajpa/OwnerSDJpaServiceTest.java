package com.example.springpetclinic.service.springdatajpa;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.repositories.OwnerRepository;
import com.example.springpetclinic.repositories.PetRepository;
import com.example.springpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    final String LAST_NAME = "somvanshi";
    final long ID = 1L;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
       when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(owner));

       Owner returnedOwner = ownerSDJpaService.findByLastName(LAST_NAME);

       assertEquals(LAST_NAME, returnedOwner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(owner);
        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> returnedSet = ownerSDJpaService.findAll();

        assertEquals(1, returnedSet.size());
    }
}