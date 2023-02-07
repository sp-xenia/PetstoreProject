package it.xenia.petstore.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.xenia.petstore.model.Order;
import it.xenia.petstore.model.Order.StatusEnum;
import it.xenia.petstore.repository.OrderRepository;
import it.xenia.petstore.service.IStoreService;

@Service
@Transactional
public class StoreService implements IStoreService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Order> get() {
		List<Order> ret = new ArrayList<>();
		orderRepository.findAll().forEach(ret::add);
		return ret;
	}
	

	@Override
	@Transactional(readOnly=false)
	public Order add(Order order) {
		Order ret = orderRepository.save(order);
		return ret;
	}
	

	@Override
	public Order get(long id) {
		return orderRepository.findById(id).get();
	}
	

	@Override
	@Transactional(readOnly=false)
	public void delete(long id) {
		orderRepository.deleteById(id);
	}
	
//	@Override
//	public Map<String, Integer> getInventory() {
//		return orderRepository.getInventory();
//	}

	
	public Map<String,Integer> getInventory() {
		Map<String, Integer> inventory = StatusEnum.initInventory();

		List<Order> allOrders = orderRepository.findAll();
		for(Order o : allOrders) {
			String key = o.getStatus().toString();
			int value = inventory.get(key);
			value++;
			inventory.put(key, value);
		}
		return inventory;
	}

}
