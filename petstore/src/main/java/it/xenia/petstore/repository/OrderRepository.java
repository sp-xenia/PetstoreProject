package it.xenia.petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.xenia.petstore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
