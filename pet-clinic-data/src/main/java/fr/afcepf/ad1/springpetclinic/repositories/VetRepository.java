package fr.afcepf.ad1.springpetclinic.repositories;

import fr.afcepf.ad1.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
