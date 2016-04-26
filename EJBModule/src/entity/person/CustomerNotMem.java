package entity.person;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CustomerNotMem extends Customer implements Serializable {

	public CustomerNotMem() {
	}
}
