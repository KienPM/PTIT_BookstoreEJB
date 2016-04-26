package entity.bank;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class CardBank extends Bank implements Serializable {
	@Column(name = "cardtype")
	private String cardType;
	@Column(name = "nameowner")
	private String nameOwner;
	@Column(name = "numcard")
	private String numCard;
	@Column(name = "dataressue")
	private Date dateRessue;

	public CardBank() {
	}

	public CardBank(String cardType, String nameOwner, String numCard, Date dateRessue) {
		this.cardType = cardType;
		this.nameOwner = nameOwner;
		this.numCard = numCard;
		this.dateRessue = dateRessue;
	}

	public CardBank(int id, float balance, String part, String cardType, String nameOwner, String numCard,
			Date dateRessue) {
		super(id, balance, part);
		this.cardType = cardType;
		this.nameOwner = nameOwner;
		this.numCard = numCard;
		this.dateRessue = dateRessue;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public Date getDateRessue() {
		return dateRessue;
	}

	public void setDateRessue(Date dateRessue) {
		this.dateRessue = dateRessue;
	}
}
