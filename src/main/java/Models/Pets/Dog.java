package Models.Pets;

import Models.Pet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Dog extends Pet {
    private String species;
    private String pedigree;
    private List<String> listOfCommands;

    public Dog(String name, Date birthday, String species, String pedigree, List<String> listOfCommands) {
        super(name, birthday, listOfCommands);
        this.species = species;
        this.pedigree = pedigree;
        this.listOfCommands = listOfCommands;
    }

    public String getSpecies() {
        return species;
    }

    public String getPedigree() {
        return pedigree;
    }

    @Override
    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return  String.format("%-8s%-5s%2d  %-5s%-8s  %-9s%-10s     %-8s%-14s  %-9s%-17s  %-9s%s %s ",
                PetsEnum.DOG,
                "[ Id=", super.getId(),
                "NAME=", super.getName(),
                "BIRTHDAY=", formatter.format(super.getBirthday()) ,
                "SPECIES=", this.species ,
                "PEDIGREE=", this.pedigree ,
                "COMMANDS=", this.listOfCommands,
                " ]");
    }

}