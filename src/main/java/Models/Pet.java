package Models;

import java.util.Date;
import java.util.List;

public class Pet extends Animal {
    private int id;
    private String name;
    private Date birthday;
    private List<String> listOfCommands;

    public Pet(String name, Date birthday, List<String> listOfCommands) {
        super(name, birthday, listOfCommands);

        this.name = name;
        this.birthday = birthday;
        this.listOfCommands = listOfCommands;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {

        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setListOfCommands(List<String> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }
}