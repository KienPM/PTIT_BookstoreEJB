package entity.person;

/**
 * Created by Ken on 29/03/2016.
 */
public class VietnamesePersonBuilder extends PersonBuilder {

    public VietnamesePersonBuilder() {
        person = new Person();
    }

    public void buildFullName(String s) {
        int index1 = s.indexOf(" ");
        int index2 = s.lastIndexOf(" ");
        FullName fullName = new FullName();
        if (index1 != -1) {
            fullName.setFName(s.substring(index2 + 1));
            fullName.setMName(s.substring(index1, index2 - index1));
            fullName.setLName(s.substring(0, index1));
        } else {
            fullName.setFName(s);
            fullName.setMName("");
            fullName.setLName("");
        }
        person.setFullName(fullName);
    }
}
