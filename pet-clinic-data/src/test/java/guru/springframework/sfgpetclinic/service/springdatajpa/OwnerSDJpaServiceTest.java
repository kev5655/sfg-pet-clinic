package guru.springframework.sfgpetclinic.service.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repo.OwnerRepo;
import guru.springframework.sfgpetclinic.repo.PetRepo;
import guru.springframework.sfgpetclinic.repo.PetTypeRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepo ownerRepo;
    @Mock
    PetRepo petRepo;
    @Mock
    PetTypeRepo petTypeRepo;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;


    @BeforeEach
    void beforeEach() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepo.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepo).findByLastName(any());
    }


    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();
        returnOwners.add(Owner.builder().id(1L).build());
        returnOwners.add(Owner.builder().id(2L).build());

        when(ownerRepo.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepo.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepo.save(any())).thenReturn(returnOwner);

        Owner savedOwner= service.save(ownerToSave);
        assertNotNull(savedOwner);

        verify(ownerRepo).save(any());

    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepo, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepo).deleteById(anyLong());
    }

}