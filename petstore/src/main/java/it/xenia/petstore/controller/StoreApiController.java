package it.xenia.petstore.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import it.xenia.petstore.model.Order;
import it.xenia.petstore.service.impl.StoreService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")
@RestController
public class StoreApiController implements StoreApi {
	@Autowired
	private StoreService storeService;

	private static final Logger log = LoggerFactory.getLogger(StoreApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public StoreApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> deleteOrder(
			@Parameter(in = ParameterIn.PATH, description = "ID of the order that needs to be deleted", required = true, schema = @Schema()) @PathVariable("orderId") Long orderId) {
		String accept = request.getHeader("Accept");
		storeService.delete(orderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Map<String, Integer>> getInventory() {
//		String accept = request.getHeader("Accept");
//		if (accept != null && accept.contains("application/json")) {
//			try {
//				return new ResponseEntity<Map<String, Integer>>(
//						objectMapper.readValue("{\n  \"key\" : 0\n}", Map.class), HttpStatus.NOT_IMPLEMENTED);
//			} catch (IOException e) {
//				log.error("Couldn't serialize response for content type application/json", e);
//				return new ResponseEntity<Map<String, Integer>>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
		Map<String,Integer> map = storeService.getInventory();
		return new ResponseEntity<Map<String, Integer>>(map,HttpStatus.OK);
	}

	public ResponseEntity<Order> getOrderById(
			@Parameter(in = ParameterIn.PATH, description = "ID of order that needs to be fetched", required = true, schema = @Schema()) @PathVariable("orderId") Long orderId) {
//		String accept = request.getHeader("Accept");
//		if (accept != null && accept.contains("application/json")) {
//			try {
//				return new ResponseEntity<Order>(objectMapper.readValue(
//						"{\n  \"petId\" : 198772,\n  \"quantity\" : 7,\n  \"id\" : 10,\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}",
//						Order.class), HttpStatus.NOT_IMPLEMENTED);
//			} catch (IOException e) {
//				log.error("Couldn't serialize response for content type application/json", e);
//				return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}

		return new ResponseEntity<Order>(storeService.get(orderId),HttpStatus.OK);
	}

	public ResponseEntity<Order> placeOrder(
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Order body) {
//		String accept = request.getHeader("Accept");
//		if (accept != null && accept.contains("application/json")) {
//			try {
//				return new ResponseEntity<Order>(objectMapper.readValue(
//						"{\n  \"petId\" : 198772,\n  \"quantity\" : 7,\n  \"id\" : 10,\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : true,\n  \"status\" : \"approved\"\n}",
//						Order.class), HttpStatus.NOT_IMPLEMENTED);
//			} catch (IOException e) {
//				log.error("Couldn't serialize response for content type application/json", e);
//				return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}

		return new ResponseEntity<Order>(storeService.add(body),HttpStatus.OK);
	}

}
