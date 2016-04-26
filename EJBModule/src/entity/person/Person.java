package entity.person;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idperson")
	protected int id;
	@OneToOne
	@JoinColumn(name = "idaddress", nullable = false)
	protected Address address;
	@OneToOne
	@JoinColumn(name = "idfullname", nullable = false)
	protected FullName fullName;

	public Person() {
	}

	public Person(int id, Address address, FullName fullName) {
		this.id = id;
		this.address = address;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
}
