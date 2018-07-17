package reviews.fullstack.national.parks;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@JsonIgnore
	@ManyToMany
	private Collection<Review> reviews;

	private String imgUrl;
	
	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}
	
	public Tag(String name, String imgUrl, Review...reviews) {
		this.name = name;
		this.imgUrl = imgUrl;
		this.reviews = new ArrayList<Review>();
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

}