package com.steelbooks.crudapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "steelbooks")
public class Steelbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id;
	
	@NotEmpty(message="Please enter a title")
	@Column(name = "title")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "photo_url")
	private String photo_url;
	
	@Column(name= "release_year")
	private String release_year;
	
	
	@Column(name= "director")
	private String director;
	
	
	@Column(name= "critic_score")
	private String critic_score;
	
	
	@Column(name= "audience_score")
	private String audience_score;
	
	@Column(name= "runtime")
	private String runtime;
	
	@Column(name= "movie_rating")
	private String movie_rating;
	
	@Lob 
	@Column(name="description")
	private String description;
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelease_year() {
		return release_year;
	}

	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
	public String getCritic_score() {
		return critic_score;
	}

	public void setCritic_score(String critic_score) {
		this.critic_score = critic_score;
	}
	
	
	public String getAudience_score() {
		return audience_score;
	}

	public void setAudience_score(String audience_score) {
		this.audience_score = audience_score;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(String movie_rating) {
		this.movie_rating = movie_rating;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public Steelbook() {
		super();
	}

	public Steelbook(String title, String genre, double price, String photo_url, String release_year,
			String director, String critic_score, String audience_score, String runtime, 
			String movie_rating, String description) {
		super();
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.photo_url = photo_url;
		this.release_year = release_year;		
		this.director = director;
		this.critic_score = critic_score;
		this.audience_score = audience_score;
		this.runtime = runtime;
		this.movie_rating = movie_rating;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

