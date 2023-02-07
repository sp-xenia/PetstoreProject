package it.xenia.petstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.xenia.petstore.model.Pet;
import it.xenia.petstore.model.Tag;
import it.xenia.petstore.model.Pet.StatusEnum;
import it.xenia.petstore.repository.PetRepository;
import it.xenia.petstore.service.IPetService;

@Service
public class PetService implements IPetService {
	@Autowired
	private PetRepository petRepository;
	
	@Override
	public List<Pet> get() {
		List<Pet> ret = new ArrayList<>();
		petRepository.findAll().forEach(ret::add);
		return ret;
	}
	

	@Override
	public Pet add(Pet pet) {
		Pet ret = petRepository.save(pet);
		return ret;
	}
	

	@Override
	public Pet get(long id) {
		Pet pet = petRepository.findById(id).get();
//		ModelMapper mm = new ModelMapper();
////		Pet entityPet = mm.map(pet, Pet.class);
//		Pet entityPet = new Pet();
//		entityPet.setName("Ciao");
		return pet;
	}
	
	@Override
	public List<Pet> getByStatus(String status) {
		List<Pet> ret = new ArrayList<>();
		petRepository.findByStatus(status).forEach(ret::add);;
		return ret;
		
	}
	
	@Override
	public List<Pet> getByTags(List<Tag> tags) {
		List<Pet> ret = new ArrayList<>();
		petRepository.findByTags(tags).forEach(ret::add);;
		return ret;
	}
	

	@Override
	public Pet update(Pet pet) {
		Pet ret = petRepository.save(pet);
		return ret;
	}
	
	@Override
	public void updateWithForm(long id, String name, String status) {
//		petRepository.update(id, name, status);
		Pet p = petRepository.findById(id).get();
		petRepository.deleteById(id);
		p.setName(name);
		p.setStatus(StatusEnum.fromValue(status));
		petRepository.save(p);
	}
	

	@Override
	public void delete(long id) {
		petRepository.deleteById(id);
	}
	
	@Override
	public void uploadImage(long id, String photoUrl) {
//		petRepository.uploadImage(id, photoUrl);
		Optional<Pet> oPet = petRepository.findById(id);
		if (oPet.isPresent()) {
			Pet pet = oPet.get();
			List<String> photoUrls = pet.getPhotoUrls();
			photoUrls.add(photoUrl);
			pet.setPhotoUrls(photoUrls);
			
			petRepository.save(pet);
		}
	}
	
}
