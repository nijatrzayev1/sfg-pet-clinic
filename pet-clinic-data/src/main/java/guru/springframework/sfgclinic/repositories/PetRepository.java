package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
