package it.xenia.petstore.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.xenia.petstore.model.Pet;
import it.xenia.petstore.model.Pet.StatusEnum;
import it.xenia.petstore.model.Tag;

public class PetRepositoryCustom implements IPetRepositoryCustom {
	@Autowired
	private PetRepository petRepository;
	
	@Override
	public List<Pet> findByStatus(String status) {
		List<Pet> allPets = petRepository.findAll();
		List<Pet> ret = new ArrayList<>();
		for(Pet p : allPets) {
			if(p.getStatus().toString().equals(status)) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	@Override
	public List<Pet> findByTags(List<Tag> tags) {
		List<Pet> allPets = petRepository.findAll();
		List<Pet> ret = new ArrayList<>();
		for(Tag t : tags) {
			for(Pet p : allPets) {
				if(p.getTags().contains(t)) {
					ret.add(p);
				}
			}
		}
		return ret;
	}
	
//	@Override
//	public void update(long id, String name, String status) {
//		Pet p = petRepository.findById(id).get();
//		petRepository.deleteById(id);
//		p.setName(name);
//		p.setStatus(StatusEnum.fromValue(status));
//		petRepository.save(p);
//	}
	
	public Optional<Pet> dummy() {
		return Optional.empty();
	}
}
