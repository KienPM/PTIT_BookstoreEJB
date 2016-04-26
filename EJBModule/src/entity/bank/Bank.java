package entity.bank;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Bank implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbank")
	private int id;
	@Column(name = "balance")
	private float balance;
	@Column(name = "part")
	private String part;

	public Bank() {
	}

	public Bank(float balance, String part) {
		this.balance = balance;
		this.part = part;
	}

	public Bank(int id, float balance, String part) {
		this.id = id;
		this.balance = balance;
		this.part = part;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
}
