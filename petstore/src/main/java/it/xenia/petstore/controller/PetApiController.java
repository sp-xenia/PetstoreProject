package it.xenia.petstore.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import it.xenia.petstore.model.ModelApiResponse;
import it.xenia.petstore.model.Pet;
import it.xenia.petstore.model.Tag;
import it.xenia.petstore.service.IPetService;
import it.xenia.petstore.service.impl.PetService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")
@RestController
public class PetApiController implements PetApi {
	@Autowired
	private IPetService petService;

	private static final Logger log = LoggerFactory.getLogger(PetApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Pet> addPet(
			@Parameter(in = ParameterIn.DEFAULT, description = "Create a new pet in the store", required = true, schema = @Schema()) @Valid @RequestBody Pet body) {
		petService.add(body);
		return new ResponseEntity<Pet>(body, HttpStatus.OK);
	}

	public ResponseEntity<Void> deletePet(
			@Parameter(in = ParameterIn.PATH, description = "Pet id to delete", required = true, schema = @Schema()) @PathVariable("petId") Long petId,
			@Parameter(in = ParameterIn.HEADER, description = "", schema = @Schema()) @RequestHeader(value = "api_key", required = false) String apiKey) {
		petService.delete(petId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<List<Pet>> findPetsByStatus(
			@Parameter(
					in = ParameterIn.QUERY, 
					description = "Status values that need to be considered for filter", 
					schema = @Schema(allowableValues = {"available", "pending", "sold" }, defaultValue = "available")) 
			@Valid @RequestParam(value = "status", required = false, defaultValue = "available") String status) {
		List<Pet> ret = petService.getByStatus(status);
		return new ResponseEntity<List<Pet>>(ret, HttpStatus.OK);
	}

	public ResponseEntity<List<Pet>> findPetsByTags(
			@Parameter(in = ParameterIn.QUERY, description = "Tags to filter by", schema = @Schema()) @Valid @RequestParam(value = "tags", required = false) List<Tag> tags) {
		List<Pet> ret = petService.getByTags(tags);
		return new ResponseEntity<List<Pet>>(ret, HttpStatus.OK);
	}

	public ResponseEntity<Pet> getPetById(
			@Parameter(in = ParameterIn.PATH, description = "ID of pet to return", required = true, schema = @Schema()) @PathVariable("petId") Long petId) {
		return new ResponseEntity<Pet>(petService.get(petId), HttpStatus.OK);
	}

	public ResponseEntity<Pet> updatePet(
			@Parameter(in = ParameterIn.DEFAULT, description = "Update an existent pet in the store", required = true, schema = @Schema()) @Valid @RequestBody Pet body) {
		return new ResponseEntity<Pet>(petService.update(body), HttpStatus.OK);
	}

	public ResponseEntity<Void> updatePetWithForm(
			@Parameter(in = ParameterIn.PATH, description = "ID of pet that needs to be updated", required = true, schema = @Schema()) @PathVariable("petId") Long petId,
			@Parameter(in = ParameterIn.QUERY, description = "Name of pet that needs to be updated", schema = @Schema()) @Valid @RequestParam(value = "name", required = false) String name,
			@Parameter(in = ParameterIn.QUERY, description = "Status of pet that needs to be updated", schema = @Schema()) @Valid @RequestParam(value = "status", required = false) String status) {
		petService.updateWithForm(petId, name, status);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<ModelApiResponse> uploadFile(
			@Parameter(in = ParameterIn.PATH, description = "ID of pet to update", required = true, schema = @Schema()) @PathVariable("petId") Long petId,
			@Parameter(in = ParameterIn.QUERY, description = "Additional Metadata", schema = @Schema()) @Valid @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata,
			@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody Object body) {
		petService.uploadImage(petId, additionalMetadata);
		return new ResponseEntity<ModelApiResponse>(HttpStatus.OK);
	}

}
