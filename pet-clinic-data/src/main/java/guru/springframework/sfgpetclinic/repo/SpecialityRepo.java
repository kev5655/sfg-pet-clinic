package guru.springframework.sfgpetclinic.repo;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepo extends CrudRepository<Speciality, Long> {
}
