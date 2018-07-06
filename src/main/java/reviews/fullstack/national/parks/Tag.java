package reviews.fullstack.national.parks;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String amenity;
	
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
	
	public Tag(String amenity, Review...reviews) {
		this.amenity = amenity;
		this.reviews = reviews;
	}
	
	public long getId() {
		return id;
	}
	
	public String getAmenity() {
		return amenity;
	}
	
	public Tag(String amenity) {
		this.amenity = amenity;
	}
	
}
