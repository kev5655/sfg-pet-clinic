package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repo.PetTypeRepo;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    public PetTypeSDJpaService(PetTypeRepo petTypeRepo) {
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepo.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepo.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepo.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepo.deleteById(aLong);
    }
}
