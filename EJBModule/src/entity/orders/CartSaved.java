package entity.orders;

import entity.person.CustomerMember;

import javax.persistence.*;

/**
 * Created by Ken on 26/04/2016.
 */
@Entity
public class CartSaved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcart_saved")
    private int id;
    @OneToOne
    @JoinColumn(name = "idcart", nullable = false)
    private Cart cart;
    @JoinColumn(name = "idperson", nullable = false)
    @OneToOne
    private CustomerMember customerMember;

    public CartSaved() {
    }

    public CartSaved(Cart cart, CustomerMember customerMember) {
        this.cart = cart;
        this.customerMember = customerMember;
    }
}
