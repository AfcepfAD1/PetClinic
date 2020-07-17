package fr.afcepf.ad1.springpetclinic.bootstrap;

import fr.afcepf.ad1.springpetclinic.model.*;
import fr.afcepf.ad1.springpetclinic.services.*;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, PetService petService, PetTypeService petTypeService, VetService vetService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert Speciality

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        System.out.println("Load Speciality");

        //Add PetType
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load PetType");

        //Add Owner & Pet
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Main Street");
        owner1.setCity("New York");
        owner1.setTelephone("12345");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rufus");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gladdale");
        owner2.setAddress("123 Upper Street");
        owner2.setCity("Boston");
        owner2.setTelephone("12345");
        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setOwner(owner2);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Meow");
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Load Owner and Pet");

        //Load visit
        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat headache");
        catVisit.setPet(fionasPet);
        visitService.save(catVisit);

        System.out.println("Load visit");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Load Vets");



    }
}
