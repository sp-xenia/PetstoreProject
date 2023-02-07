package it.xenia.petstore.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Address
 */
@Entity
@Table
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")
public class Address implements Serializable {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Street")
	@JsonProperty("street")
	private String street = null;

	@Column(name="City")
	@JsonProperty("city")
	private String city = null;

	@Column(name="State")
	@JsonProperty("state")
	private String state = null;

	@Column(name="Zip")
	@JsonProperty("zip")
	private String zip = null;

	public Address street(String street) {
		this.street = street;
		return this;
	}

	/**
	 * Get street
	 * 
	 * @return street
	 **/
	@Schema(example = "437 Lytton", description = "")

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address city(String city) {
		this.city = city;
		return this;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 **/
	@Schema(example = "Palo Alto", description = "")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address state(String state) {
		this.state = state;
		return this;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 **/
	@Schema(example = "CA", description = "")

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address zip(String zip) {
		this.zip = zip;
		return this;
	}

	/**
	 * Get zip
	 * 
	 * @return zip
	 **/
	@Schema(example = "94301", description = "")

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(this.street, address.street) && Objects.equals(this.city, address.city)
				&& Objects.equals(this.state, address.state) && Objects.equals(this.zip, address.zip);
	}

	@Override
	public int hashCode() {
		return Objects.hash(street, city, state, zip);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Address {\n");

		sb.append("    street: ").append(toIndentedString(street)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
