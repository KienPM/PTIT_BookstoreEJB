package entity.book;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategory")
	private int id;
	@Column(name = "type")
	private String type;
	@Column(name = "area")
	private String area;
	@Column(name = "description")
	private String description;

	public Category(int id, String type, String area, String description) {
		this.id = id;
		this.type = type;
		this.area = area;
		this.description = description;
	}

	public Category() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
