package Models;

import java.util.Date;
import java.util.List;

public class PackAnimal extends Animal {
    private int id;
    private String name;
    private Date birthday;
    private int loadCapacity;
    private List<String> listOfCommands;

    public PackAnimal(String name, Date birthday, int loadCapacity, List<String> listOfCommands) {
        super(name, birthday, listOfCommands);

        this.name = name;
        this.birthday = birthday;
        this.loadCapacity = loadCapacity;

    }

    public int getId() {
        return id;
    }


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

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setListOfCommands(List<String> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }
}