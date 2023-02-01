package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeService extends CrudService<PetType, Long> {
}
