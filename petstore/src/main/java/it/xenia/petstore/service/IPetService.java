package it.xenia.petstore.service;

import java.util.List;

import it.xenia.petstore.model.Pet;
import it.xenia.petstore.model.Tag;

public interface IPetService extends CRUDService<Pet> {
	public List<Pet> getByStatus(String status);
	public void uploadImage(long id, String photoUrl);
	public Pet update(Pet pet);
	public void updateWithForm(long id, String name, String status);
	public List<Pet> getByTags(List<Tag> tags);
}
