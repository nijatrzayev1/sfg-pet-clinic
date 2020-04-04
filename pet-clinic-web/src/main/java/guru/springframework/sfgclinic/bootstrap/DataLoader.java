package guru.springframework.sfgclinic.bootstrap;

import guru.springframework.sfgclinic.model.*;
import guru.springframework.sfgclinic.services.OwnerService;
import guru.springframework.sfgclinic.services.PetTypeService;
import guru.springframework.sfgclinic.services.SpecialityService;
import guru.springframework.sfgclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petService;
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petService.findAll().size();
        if (count==0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadilogy = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 =  new Owner();
        owner1.setFirstName("Nijat");
        owner1.setLastName("Rzayev");
        owner1.setAddress("123 Baku");
        owner1.setCity("Miami");
        owner1.setTelephone("123123");

        Pet nijatPet = new Pet();
        nijatPet.setPetType(savedDogPetType);
        nijatPet.setOwner(owner1);
        nijatPet.setBirthDate(LocalDate.now());
        nijatPet.setName("Rosco");
        owner1.getPets().add(nijatPet);

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Uluxan");
        owner2.setLastName("Rzayev");
        owner1.setAddress("62 Zaqatala");
        owner1.setCity("Zakatala");
        owner1.setTelephone("987987");

        Pet uluxanPet = new Pet();
        uluxanPet.setPetType(savedCatPetType);
        uluxanPet.setOwner(owner2);
        uluxanPet.setBirthDate(LocalDate.now());
        uluxanPet.setName("Just Cat");
        owner1.getPets().add(uluxanPet);
        ownerService.save(owner2);

        System.out.println("Owners loaded..........");
        Vet vet1 = new Vet();
        vet1.setFirstName("Hamu1");
        vet1.setLastName("HamuSoyad");
        vet1.getSpecialities().add(savedRadilogy);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Hamu2");
        vet2.setLastName("HamuSoyad2");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vets loaded..........");
    }
}
