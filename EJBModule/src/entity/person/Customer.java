package entity.person;

import java.io.Serializable;

import javax.persistence.*;

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends Person implements Serializable {
	@Column(name = "phonenum")
	private String phoneNum;
	@Column(name = "email")
	private String email;

	public Customer() {
	}

	public Customer(int id, String phoneNum, String email) {
		this.id = id;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
