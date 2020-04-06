package guru.springframework.sfgclinic.repositories;

import guru.springframework.sfgclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
