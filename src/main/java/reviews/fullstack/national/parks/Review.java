package reviews.fullstack.national.parks;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Review {

	
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Lob
	private String description;

	private String imgUrl;
	
	
	@ManyToOne
	private Trip trip;
	
	@ManyToMany(mappedBy = "reviews")
	private Collection<Tag> tags;
	
	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;
	
	public Review() {
		
	}
	
	public Review (String name) {
		this.name = name;
	}
	
	public Review(String name, String description, String imgUrl, Trip trip) {
		this.name = name;
		this.description = description;
		this.trip = trip;
		this.setImgUrl(imgUrl);
	}

	
	public Long getId() {
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
 