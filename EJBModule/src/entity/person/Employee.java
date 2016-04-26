package entity.person;

import java.io.Serializable;

import javax.persistence.*;

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Person implements Serializable {
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "phoneNum")
	private String phoneNum;
	@Column(name = "email")
	private String email;

	public Employee() {
	}

	public Employee(int id, String username, String password, String phoneNum, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
