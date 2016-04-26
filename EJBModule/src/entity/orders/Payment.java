package entity.orders;

import java.io.Serializable;

import javax.persistence.*;

import entity.bank.Bank;

@Entity
public class Payment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpayment")
	private int id;
	@ManyToOne
	@JoinColumn(name = "idbank", nullable = false)
	private Bank bank;
	@OneToOne
	@JoinColumn(name = "idcart", nullable = false)
	private Cart cart;

	public Payment() {
	}

	public Payment(int id, Bank bank, Cart cart) {
		this.id = id;
		this.bank = bank;
		this.cart = cart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
