package fr.afcepf.ad1.springpetclinic.repositories;


import fr.afcepf.ad1.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
