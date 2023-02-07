package it.xenia.petstore.service;

import java.io.IOException;
import java.util.Map;

import it.xenia.petstore.model.Order;

public interface IStoreService extends CRUDService<Order> {
	public Map<String, Integer> getInventory() throws IOException;
}
