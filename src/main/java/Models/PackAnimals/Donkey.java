package Models.PackAnimals;

import Models.PackAnimal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Donkey extends PackAnimal {
    private String species;
    private List<String> listOfCommands;

    public Donkey(String name, Date birthday, int loadCapacity, String species, List<String> listOfCommands) {
        super(name, birthday, loadCapacity, listOfCommands);
        this.species = species;
        this.listOfCommands = listOfCommands;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return String.format("%-8s%-5s%2d  %-5s%-8s  %-9s%-10s     %-8s%-14s  %-9s%-13s  %-9s%s %s ",
                PackAnimalsEnum.DONKEY,
                "[ Id=", super.getId(),
                "NAME=", super.getName(),
                "BIRTHDAY=", formatter.format(super.getBirthday()),
                "SPECIES=", this.species,
                "LoadCapacity=", super.getLoadCapacity(),
                "COMMANDS=", this.listOfCommands,
                "] ");
    }
}
