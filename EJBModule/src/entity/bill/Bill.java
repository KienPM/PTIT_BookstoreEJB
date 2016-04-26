package entity.bill;

import entity.orders.Orders;
import entity.person.Seller;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Bill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbill")
	private int id;
	@OneToOne
	@JoinColumn(name = "idorders", nullable = false)
	private Orders order;
	@OneToOne
	@JoinColumn(name = "idperson", nullable = false)
	private Seller seller;
	@Column(name = "date")
	private Date date;

	public Bill(int id, Orders order, Seller seller, Date date) {
		this.id = id;
		this.order = order;
		this.seller = seller;
		this.date = date;
	}

	public Bill() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
