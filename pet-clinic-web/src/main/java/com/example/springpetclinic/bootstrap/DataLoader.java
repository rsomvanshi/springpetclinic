package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.Owner;
import com.example.springpetclinic.model.Vet;
import com.example.springpetclinic.service.OwnerService;
import com.example.springpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setFirstName("Rohan");
        o1.setLastName("Somvanshi");

        Owner o2 = new Owner();
        o2.setFirstName("Rahul");
        o2.setLastName("Somvanshi");

        ownerService.save(o1);
        ownerService.save(o2);

        System.out.println("Loaded Owners ....");

        Vet v1 = new Vet();
        v1.setFirstName("XXX");
        v1.setLastName("YYY");

        Vet v2 = new Vet();
        v2.setFirstName("PPP");
        v2.setLastName("QQQ");

        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vets ....");
    }
}
