package it.xenia.petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.xenia.petstore.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>, IPetRepositoryCustom {
	
}
