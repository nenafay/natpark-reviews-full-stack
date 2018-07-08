package reviews.fullstack.national.parks;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Review {

	
	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String description;

	private String imgUrl;
	
	public Review (String name) {
		this.name = name;
	}
	
	public Review(String name, String description, String imgUrl, Trip trip, Tag...tags) {
		this.name = name;
		this.description = description;
		this.trip = trip;
		this.tags = new HashSet<>(Arrays.asList(tags));
		this.imgUrl = imgUrl;
	}
	
	public Review() {
		
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
	
	public Trip getTrip() {
		return trip;
	}
	
	@ManyToOne
	private Trip trip;
	
	@ManyToMany
	private Collection<Tag> tags;

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
		Review other = (Review) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
 