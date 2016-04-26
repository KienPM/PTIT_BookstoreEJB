package entity.orders;

import java.io.Serializable;

import javax.persistence.*;

import entity.book.*;

@Entity
public class BookOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbook_order")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @OneToOne
    @JoinColumn(name = "idbook", nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "idcart", nullable = false)
    private Cart cart;

    public BookOrder() {
    }

    public BookOrder(Book book, int quantity, Cart cart) {
        this.quantity = quantity;
        this.book = book;
        this.cart = cart;
    }

    public BookOrder(int id, Book book, int quantity) {
        this.id = id;
        this.quantity = quantity;
        this.book = book;
    }

    public BookOrder(int id, Book book, int quantity, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.book = book;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQuantity() {
        ++quantity;
    }

    public float getTotalPrice() {
        return quantity * Float.parseFloat(book.getSalePrice());
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
