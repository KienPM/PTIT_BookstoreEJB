package entity.orders;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ha Thanh Tam on 01/03/2016.
 */
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcart")
    private int id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
    private List<BookOrder> list;

    public Cart() {
    }

    public Cart(int id, List<BookOrder> list) {
        this.id = id;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookOrder> getList() {
        return list;
    }

    public void setList(List<BookOrder> list) {
        this.list = list;
    }

    public float getTotalPrice() {
        float sum = 0;
        for (BookOrder bo : list) {
            sum += bo.getTotalPrice();
        }
        return sum;
    }

    public void addToCart(BookOrder bo) {
        boolean found = false;
        for (BookOrder bookOrder : list) {
            if (bookOrder.getBook().getId() == bo.getBook().getId()) {
                bookOrder.incQuantity();
                found = true;
            }
        }
        if (!found) {
            list.add(bo);
        }
    }
}
