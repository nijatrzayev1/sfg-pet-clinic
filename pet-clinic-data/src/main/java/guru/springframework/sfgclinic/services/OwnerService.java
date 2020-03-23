package guru.springframework.sfgclinic.services;

import guru.springframework.sfgclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
