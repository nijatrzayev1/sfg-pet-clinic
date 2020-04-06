package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
