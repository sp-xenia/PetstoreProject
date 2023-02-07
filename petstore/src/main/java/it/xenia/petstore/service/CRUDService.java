package it.xenia.petstore.service;

import java.io.IOException;
import java.util.List;

public interface CRUDService<T> {
	
	public List<T> get();
	public T add(T o);
	public T get(long id);
	public void delete(long id);
	
}
