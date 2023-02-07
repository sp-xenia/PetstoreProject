package it.xenia.petstore.repository;

import java.util.List;

import it.xenia.petstore.model.Pet;
import it.xenia.petstore.model.Tag;

public interface IPetRepositoryCustom {
	public List<Pet> findByStatus(String status);
	public List<Pet> findByTags(List<Tag> tags);
//	public void uploadImage(long id, String photoUrl);
//	public void update(long id, String name, String status);
}
