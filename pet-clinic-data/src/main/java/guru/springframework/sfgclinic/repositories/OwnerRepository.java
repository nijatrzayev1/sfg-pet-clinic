package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
