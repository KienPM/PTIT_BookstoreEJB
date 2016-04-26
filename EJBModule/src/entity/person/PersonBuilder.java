package entity.person;

/**
 * Created by Ken on 29/03/2016.
 */
public abstract class PersonBuilder {
    protected Person person;

    public void buildAddress(String s) {
        String[] tokens = s.split("[\\-\\/]+");
        Address address = new Address();
        if (tokens.length == 3) {
            address.setWard(tokens[0].trim());
            address.setDistrict(tokens[1].trim());
            address.setCity(tokens[2].trim());
        } else if (tokens.length == 4) {
            address.setNum(tokens[0].trim());
            address.setWard(tokens[1].trim());
            address.setDistrict(tokens[2].trim());
            address.setCity(tokens[3].trim());
        }
        person.setAddress(address);
    }

    public abstract void buildFullName(String s);

    public Person getPerson() {
        return person;
    }
}
