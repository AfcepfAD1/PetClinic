package fr.afcepf.ad1.springpetclinic.repositories;


import fr.afcepf.ad1.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
