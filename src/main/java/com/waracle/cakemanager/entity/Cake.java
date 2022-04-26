package com.waracle.cakemanager.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;

@Entity
@Table(name="Cake")
public class Cake {
	
	public Cake() {}
		
	public Cake(String title, String description, String image) {
		this.title = title;
		this.description = description;
		this.image = image;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	@JsonAlias("desc")
	private String description;
	
	@Column(name = "image")
	private String image;
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Cake [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, image, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cake other = (Cake) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(title, other.title);
	}
	
	
}
