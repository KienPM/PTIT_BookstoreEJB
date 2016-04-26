package entity.book;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class BookSet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbookset")
	private int id;
	@Column(name = "description")
	private String description;

	public BookSet() {
	}

	public BookSet(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
