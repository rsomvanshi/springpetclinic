package com.example.springpetclinic.bootstrap;

import com.example.springpetclinic.model.*;
import com.example.springpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final PetService  petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.petService = petService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        dog.setName("Cat");
        petTypeService.save(cat);
        petTypeService.save(dog);

        Owner o1 = new Owner();
        o1.setFirstName("Rohan");
        o1.setLastName("Somvanshi");
        o1.setAddress("500 Doris ave");
        o1.setCity("Toronto");
        o1.setTelephone("12345678");

        Owner o2 = new Owner();
        o2.setFirstName("Rahul");
        o2.setLastName("Somvanshi");
        o2.setAddress("500 Doris ave");
        o2.setCity("Toronto");
        o2.setTelephone("12345678");
        ownerService.save(o1);
        ownerService.save(o2);

        Pet p1 = new Pet();
        p1.setOwner(o1);
        p1.setPetType(dog);
        p1.setBirthDate(LocalDate.now());

        Pet p2 = new Pet();
        p2.setOwner(o2);
        p2.setPetType(cat);
        p2.setBirthDate(LocalDate.now());
        petService.save(p1);
        petService.save(p2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(p1);
        catVisit.setDescription("Cat visit");
        visitService.save(catVisit);


        System.out.println("Loaded Owners ....");

        Vet v1 = new Vet();
        v1.setFirstName("XXX");
        v1.setLastName("YYY");

        Vet v2 = new Vet();
        v2.setFirstName("PPP");
        v2.setLastName("QQQ");

        Speciality s1 = new Speciality();
        s1.setDescription("Dentist");
        specialityService.save(s1);

        Speciality s2 = new Speciality();
        s2.setDescription("Radiology");
        specialityService.save(s2);

        v1.getSpecialities().add(s1);
        v2.getSpecialities().add(s2);
        vetService.save(v1);
        vetService.save(v2);

        System.out.println("Loaded Vets ....");
    }
}
