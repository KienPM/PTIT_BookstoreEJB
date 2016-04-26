package entity.orders;

import java.io.Serializable;

import javax.persistence.*;

import entity.person.Customer;

@Entity
public class ShippingInfor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpayment")
	private int id;
	@OneToOne
	@JoinColumn(name = "idperson", nullable = false)
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "idaddress_shipping", nullable = false)
	private AddressShipping address;

	public ShippingInfor() {
	}

	public ShippingInfor(Customer customer, AddressShipping address) {
		this.customer = customer;
		this.address = address;
	}

	public ShippingInfor(int id, Customer customer, AddressShipping address) {
		this.id = id;
		this.customer = customer;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AddressShipping getAddress() {
		return address;
	}

	public void setAddress(AddressShipping address) {
		this.address = address;
	}
}
