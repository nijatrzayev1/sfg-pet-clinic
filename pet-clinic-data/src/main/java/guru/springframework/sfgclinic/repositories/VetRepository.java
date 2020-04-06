package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
