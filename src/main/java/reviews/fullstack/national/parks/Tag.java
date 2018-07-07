package reviews.fullstack.national.parks;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.assertj.core.util.Arrays;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	
	@ManyToMany(mappedBy = "tags")
	private Collection<Review> reviews;

	public Tag() {
		
	}
	
	public Tag(String name, Review...reviews) {
		this.name = name;
		this.reviews = new HashSet<>(Arrays.asList(reviews);
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Tag(String name) {
		this.name = name;
	}
	
}
