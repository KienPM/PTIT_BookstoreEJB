package entity.book;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Book implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idbook")
	private int id;
	@Column(name = "image")
	private String image;
	@Column(name = "tile")
	private String title;
	@ManyToOne
	@JoinColumn(name = "idauthor", nullable = false)
	private Author author;
	@ManyToOne
	@JoinColumn(name = "idpublisher", nullable = false)
	private Publisher publisher;
	@Column(name = "publishyear")
	private String publishYear;
	@ManyToOne
	@JoinColumn(name = "idcategory", nullable = false)
	private Category category;
	@Column(name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "idbookset", nullable = false)
	private BookSet bookSet;
	@Column(name = "originalprice")
	private String originalPrice;
	@Column(name = "saleprice")
	private String salePrice;
	@Column(name = "quantity")
	private int quantity;

	public Book() {
		super();
	}

	public Book(int id, String image, String title, Author author, Publisher publisher, String publishYear,
			Category category, String description, BookSet bookSet, String originalPrice, String salePrice,
			int quantity) {
		super();
		this.id = id;
		this.image = image;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.category = category;
		this.description = description;
		this.bookSet = bookSet;
		this.originalPrice = originalPrice;
		this.salePrice = salePrice;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookSet getBookSet() {
		return bookSet;
	}

	public void setBookSet(BookSet bookSet) {
		this.bookSet = bookSet;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
