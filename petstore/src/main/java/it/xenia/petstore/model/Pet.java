package it.xenia.petstore.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import it.xenia.petstore.model.converter.PhotoUrlsConverter;

/**
 * Pet
 */
@Entity
@Table
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-01-24T08:53:54.400Z[GMT]")

public class Pet implements Serializable {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id = null;

	@Column(name="Name")
	@JsonProperty("name")
	private String name = null;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "CategoryId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonProperty("category")
	private Category category = null;

	@Convert(converter = PhotoUrlsConverter.class)
	@Column(name="PhotoUrls")
	@JsonProperty("photoUrls")
	@Valid
	private List<String> photoUrls = new ArrayList<String>();
	
	@ManyToMany(fetch = FetchType.EAGER,
		        cascade = {
		        CascadeType.PERSIST,
		        CascadeType.MERGE })
	@JoinTable(name = "pet_tags",
		       joinColumns = { @JoinColumn(name = "pet_id") },
		       inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	@JsonProperty("tags")
	@Valid
	private List<Tag> tags = null;

	/**
	 * pet status in the store
	 */
	public enum StatusEnum {
		AVAILABLE("available"),

		PENDING("pending"),

		SOLD("sold");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@Column(name="Status")
	@Enumerated(EnumType.STRING)
	@JsonProperty("status")
	private StatusEnum status = null;

	public Pet() {
//		this.id = id;
//		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@Schema(example = "10", description = "")

	public Long getId() {
		return id;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}

	public Pet name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@Schema(example = "doggie", required = true, description = "")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet category(Category category) {
		this.category = category;
		return this;
	}

	/**
	 * Get category
	 * 
	 * @return category
	 **/
	@Schema(description = "")

	@Valid
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Pet photoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
		return this;
	}

	public Pet addPhotoUrlsItem(String photoUrlsItem) {
		this.photoUrls.add(photoUrlsItem);
		return this;
	}

	/**
	 * Get photoUrls
	 * 
	 * @return photoUrls
	 **/
	@Schema(required = true, description = "")
	@NotNull

	public List<String> getPhotoUrls() {
		return photoUrls;
	}

	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}

	public Pet tags(List<Tag> tags) {
		this.tags = tags;
		return this;
	}

	public Pet addTagsItem(Tag tagsItem) {
		if (this.tags == null) {
			this.tags = new ArrayList<Tag>();
		}
		this.tags.add(tagsItem);
		return this;
	}

	/**
	 * Get tags
	 * 
	 * @return tags
	 **/
	@Schema(description = "")
	@Valid
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Pet status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * pet status in the store
	 * 
	 * @return status
	 **/
	@Schema(description = "pet status in the store")

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Pet pet = (Pet) o;
		return Objects.equals(this.id, pet.id) && Objects.equals(this.name, pet.name)
				&& Objects.equals(this.category, pet.category) && Objects.equals(this.photoUrls, pet.photoUrls)
				&& Objects.equals(this.tags, pet.tags) && Objects.equals(this.status, pet.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, category, photoUrls, tags, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Pet {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
		sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
}
