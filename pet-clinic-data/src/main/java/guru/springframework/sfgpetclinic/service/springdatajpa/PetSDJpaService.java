package guru.springframework.sfgpetclinic.service.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repo.PetRepo;
import guru.springframework.sfgpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetRepo petRepo;

    public PetSDJpaService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepo.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepo.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepo.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepo.deleteById(aLong);
    }
}
