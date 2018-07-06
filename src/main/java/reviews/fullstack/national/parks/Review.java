package reviews.fullstack.national.parks;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String description;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public Collection<Trip> getTrips() {
		return trips;
	}
	
	public void setTrip(Collection<Trip> trips) {
		this.trips = trips;
	}
	
	@ManyToOne
	private Collection<Object> reviews;
	
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
	
	public Review(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@ManyToOne
	private Collection<Trip> trips;
	

}
 