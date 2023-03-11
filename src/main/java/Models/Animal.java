package Models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Animal {
    private List<Objects> listAnimal;

    private int Id;
    private String name;
    private Date birthday;


    private List<String> listOfCommands;

    public Animal(String name, Date birthday, List<String> listOfCommands) {
        this.name = name;
        this.birthday = birthday;
        this.listOfCommands = listOfCommands;

    }


    public void setId(int id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setNewCommand(String newCommand) {
        listOfCommands.add(newCommand);
    }

    public void deleteCommand() {
        listOfCommands.clear();
    }


}