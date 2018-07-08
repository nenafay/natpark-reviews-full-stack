package reviews.fullstack.national.parks;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trip {
		
	@Id
	@GeneratedValue

	private long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "trip")
	private Collection<Review> reviews;
	private String imgUrl;
	
	public Trip() {
		
	}
		
	public Trip(String name, String description, String imgUrl) {
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
	}

	public long getId() {
		return id;
			
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

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
		Trip other = (Trip) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}
	
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	

}
