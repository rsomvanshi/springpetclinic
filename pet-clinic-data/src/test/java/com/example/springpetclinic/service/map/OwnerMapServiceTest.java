package com.example.springpetclinic.service.map;

import com.example.springpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final long id = 1L;
    final String lastName = "somvanshi";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1 ,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);

        assertEquals(id, owner.getId());
    }

    @Test
    void save() {
        Owner owner = ownerMapService.save(Owner.builder().id(id).build());

        assertEquals(id, owner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);

        assertEquals(id, owner.getId());
    }
}