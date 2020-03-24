package guru.springframework.sfgclinic.bootstrap;

import guru.springframework.sfgclinic.model.Owner;
import guru.springframework.sfgclinic.model.Vet;
import guru.springframework.sfgclinic.services.OwnerService;
import guru.springframework.sfgclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 =  new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nijat");
        owner1.setLastName("Rzayev");
        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Uluxan");
        owner2.setLastName("Rzayev");
        ownerService.save(owner2);

        System.out.println("Owners loaded..........");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Hamu1");
        vet1.setLastName("HamuSoyad");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Hamu2");
        vet2.setLastName("HamuSoyad2");
        vetService.save(vet2);

        System.out.println("Vets loaded..........");

    }
}
