package entity.person;

import java.io.Serializable;

import javax.persistence.*;

import entity.bank.KcoinBank;

@Entity
public class CustomerMember extends Customer implements Serializable {
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@OneToOne
	@JoinColumn(name = "idbank", nullable = false)
	private KcoinBank kcoinBank;

	public CustomerMember() {
	}

	public CustomerMember(Person person) {
		this.id = person.getId();
		this.setAddress(person.getAddress());
		this.setFullName(person.getFullName());
	}

	public CustomerMember(int id, String username, String password, KcoinBank kcoinBank) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.kcoinBank = kcoinBank;
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

	public KcoinBank getKcoinBank() {
		return kcoinBank;
	}

	public void setKcoinBank(KcoinBank kcoinBank) {
		this.kcoinBank = kcoinBank;
	}
}
