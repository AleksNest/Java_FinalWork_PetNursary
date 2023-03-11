package Repository;

import Models.Animal;
import Models.Nursery;
import Models.PackAnimals.Camel;
import Models.PackAnimals.Donkey;
import Models.PackAnimals.Horse;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.io.File.separator;


public class WriteToFile {

    String path = "src" + separator + "main" + separator + "java" + separator + "Nursery.txt";
    public File file;
    List<Animal> animals;
    Nursery nursery;


    public WriteToFile() throws FileNotFoundException {
        this.file = new File(path);
    }

    /**
     * method to save data to file
     **/
    public void writeToFile(Nursery nursery) throws IOException {
        String str;
        fileСleaning(path);
        PrintWriter pw = new PrintWriter((new FileWriter(path, true)));
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        for (Animal pet : nursery.getAnimals()) {

            if (pet instanceof Cat) {

                pw.println("Cat " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Cat) pet).getBirthday()) + " " + ((Cat) pet).getSpecies() + " " + covertListToString(pet.getListOfCommands()));
            }
            if (pet instanceof Hamster) {
                pw.println("Hamster " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Hamster) pet).getBirthday()) + " " + ((Hamster) pet).getSpecies() + " " + covertListToString(pet.getListOfCommands()));
            }
            if (pet instanceof Dog) {
                pw.println("Dog " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Dog) pet).getBirthday()) + " " + ((Dog) pet).getSpecies() + " " + ((Dog) pet).getPedigree() + " " + covertListToString(pet.getListOfCommands()));
            }
            if (pet instanceof Horse) {
                pw.println("Horse " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Horse) pet).getBirthday()) + " " + ((Horse) pet).getLoadCapacity() + " " + ((Horse) pet).getSpecies() + " " + covertListToString(pet.getListOfCommands()));
            }
            if (pet instanceof Donkey) {
                pw.println("Horse " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Donkey) pet).getBirthday()) + " " + ((Donkey) pet).getLoadCapacity() + " " + ((Donkey) pet).getSpecies() + " " + covertListToString(pet.getListOfCommands()));
            }
            if (pet instanceof Camel) {
                pw.println("Horse " + pet.getId() + " " + pet.getName() + " " + formatter.format(((Camel) pet).getBirthday()) + " " + ((Camel) pet).getLoadCapacity() + " " + ((Camel) pet).getNumberOfHumps() + " " + covertListToString(pet.getListOfCommands()));
            }
        }
        pw.close();
    }


    /**
     * List to string conversion method
     **/
    public String covertListToString(List<String> ListOfCommands) {
        String str = "";
        if (!ListOfCommands.isEmpty()) {
            String[] listToStr = ListOfCommands.toString().split(", ");

            String pos = " ";
            for (int i = 0; i < listToStr.length; i++) {
                if (i == listToStr.length - 1) {
                    str = str + listToStr[i];
                } else {
                    str = str + listToStr[i] + pos;
                }

            }

            return str.substring(1).replaceFirst(".$", "");
        } else return str;

    }


    /**
     * file cleanup method
     **/
    public static void fileСleaning(String path) {

        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(path),
                StandardOpenOption.TRUNCATE_EXISTING)) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

