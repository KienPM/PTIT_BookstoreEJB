package entity.book;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Publisher implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpublisher")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	public Publisher() {
	}

	public Publisher(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
