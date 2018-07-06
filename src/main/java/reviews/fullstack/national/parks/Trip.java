package reviews.fullstack.national.parks;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.assertj.core.util.Arrays;

@Entity
public class Trip {
		
	@Id
	@GeneratedValue

	private long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "trip")
	private Collection<Object> reviews;
	
	public Trip() {
		
	}
		
	public Trip(String name, String description, Review...reviews) {
		this.name = name;
		this.description = description;
		this.reviews = new HashSet<>(Arrays.asList(reviews));
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

	public Collection<Object> getReviews() {
		return reviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		return true;
	}
	

}
