package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repo.OwnerRepo;
import guru.springframework.sfgpetclinic.repo.PetRepo;
import guru.springframework.sfgpetclinic.repo.PetTypeRepo;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepo ownerRepo;
    private final PetRepo petRepo;
    private final PetTypeRepo petTypeRepo;

    public OwnerSDJpaService(OwnerRepo ownerRepo, PetRepo petRepo, PetTypeRepo petTypeRepo) {
        this.ownerRepo = ownerRepo;
        this.petRepo = petRepo;
        this.petTypeRepo = petTypeRepo;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepo.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepo.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepo.findById(aLong);
        return optionalOwner.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepo.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepo.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepo.findByLastName(lastName);
    }


}
