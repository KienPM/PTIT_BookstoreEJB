package entity.bank;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class KcoinBank extends Bank implements Serializable {

    public KcoinBank() {
    }

    public KcoinBank(float balance, String part) {
        super(balance, part);
    }

    public KcoinBank(int id, float balance, String part) {
        super(id, balance, part);
    }
}
