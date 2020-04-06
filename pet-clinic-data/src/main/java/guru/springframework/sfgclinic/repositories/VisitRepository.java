package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
