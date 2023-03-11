package Repository;

import Models.Animal;
import Models.Nursery;
import Models.PackAnimals.Camel;
import Models.PackAnimals.Donkey;
import Models.PackAnimals.Horse;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoadFromFile {
    public File file;

    Nursery nursery;
    public List<Animal> animals;

    public LoadFromFile(Nursery nursery) {
        this.nursery = nursery;
    }


    /**
     * method to load data from a file
     **/
    public List<Animal> loadNurseryFromFile() {


        System.out.println("dataBase: Nursery is loaded!");
        String type;
        int id;
        String name;
        Date birthday = null;
        String species;
        int loadCapacity;
        int numberOfHump;
        String pedigree;
        List<String> listOfCommands;
        String separator = File.separator;
        String path = "src" + separator + "main" + separator + "java" + separator + "Nursery.txt";
        this.file = new File(path);
        System.out.println("data from file Nursery.txt: ");
        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            int i = 0;

            while (line != null) {
                String[] numbersString = line.split(" ");
                if (numbersString[0].equals("Cat")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];

                    id = Integer.parseInt(numbersString[1]);

                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    species = numbersString[4];
                    for (i = 5; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Cat newCat = new Cat(name, birthday, species, listOfCommands);
                    nursery.addNewAnimal(newCat);
                }
                if (numbersString[0].equals("Dog")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];
                    id = Integer.parseInt(numbersString[1]);
                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    species = numbersString[4];
                    pedigree = numbersString[5];
                    for (i = 6; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Dog newDog = new Dog(name, birthday, species, pedigree, listOfCommands);
                    nursery.addNewAnimal(newDog);

                }
                if (numbersString[0].equals("Hamster")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];
                    id = Integer.parseInt(numbersString[1]);
                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    species = numbersString[4];
                    for (i = 5; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Hamster newHamster = new Hamster(name, birthday, species, listOfCommands);
                    nursery.addNewAnimal(newHamster);
                }

                if (numbersString[0].equals("Camel")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];
                    id = Integer.parseInt(numbersString[1]);
                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    loadCapacity = Integer.parseInt(numbersString[4]);
                    numberOfHump = Integer.parseInt(numbersString[5]);
                    for (i = 6; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Camel newCamel = new Camel(name, birthday, loadCapacity, numberOfHump, listOfCommands);
                    nursery.addNewAnimal(newCamel);

                }
                if (numbersString[0].equals("Donkey")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];
                    id = Integer.parseInt(numbersString[1]);
                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    species = numbersString[5];
                    loadCapacity = Integer.parseInt(numbersString[4]);
                    for (i = 6; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Donkey newDonkey = new Donkey(name, birthday, loadCapacity, species, listOfCommands);
                    nursery.addNewAnimal(newDonkey);

                }
                if (numbersString[0].equals("Horse")) {
                    listOfCommands = new ArrayList<>();
                    type = numbersString[0];
                    id = Integer.parseInt(numbersString[1]);
                    name = numbersString[2];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        birthday = dateFormat.parse(numbersString[3]);

                    } catch (ParseException e) {

                        e.printStackTrace();

                    }
                    species = numbersString[5];
                    loadCapacity = Integer.parseInt(numbersString[4]);
                    for (i = 6; i < numbersString.length; i++) {
                        listOfCommands.add(numbersString[i]);
                    }
                    Horse newHorse = new Horse(name, birthday, loadCapacity, species, listOfCommands);
                    nursery.addNewAnimal(newHorse);

                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }
}
