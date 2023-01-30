package guru.springframework.sfgpetclinic.repo;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.nio.file.LinkOption;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {
}
