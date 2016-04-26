package entity.orders;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idorders")
	private int id;
	@OneToOne
	@JoinColumn(name = "idshipping_infor", nullable = false)
	private ShippingInfor shipping;
	@OneToOne
	@JoinColumn(name = "idpayment", nullable = false)
	private Payment payment;
	@Column(name = "date")
	private Date date;
	@Transient
	private OrdersState state;

	public Orders() {
	}

	public Orders(int id, ShippingInfor shipping, Payment payment, Date date) {
		this.id = id;
		this.shipping = shipping;
		this.payment = payment;
		this.date = date;
	}

	public Orders(int id, ShippingInfor shipping, Payment payment, Date date, OrdersState state) {
		this.id = id;
		this.shipping = shipping;
		this.payment = payment;
		this.date = date;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShippingInfor getShipping() {
		return shipping;
	}

	public void setShipping(ShippingInfor shipping) {
		this.shipping = shipping;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getState() {
		return state.toString();
	}

	public void setState(OrdersState state) {
		this.state = state;
	}
}
