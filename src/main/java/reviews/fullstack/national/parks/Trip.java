package reviews.fullstack.national.parks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trip {
		
	@Id
	@GeneratedValue

	private long id;
	private String name;
		
	public Trip() {
			
	}

	public Trip(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
			
	}

	public String getName() {
		return name;
	}

}
