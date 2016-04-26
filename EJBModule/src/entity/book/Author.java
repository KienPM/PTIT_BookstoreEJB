package entity.book;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Author implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idauthor")
	private int id;
	@Column(name = "name")
	private String name;

	public Author() {
		super();
	}

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
