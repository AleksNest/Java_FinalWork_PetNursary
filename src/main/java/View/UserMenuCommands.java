package View;

import Models.Animal;
import Models.Nursery;
import Models.PackAnimals.Camel;
import Models.PackAnimals.Donkey;
import Models.PackAnimals.Horse;
import Models.PackAnimals.PackAnimalsEnum;
import Models.Pets.Cat;
import Models.Pets.Dog;
import Models.Pets.Hamster;
import Models.Pets.PetsEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMenuCommands {

    Nursery nursery;
    String userSelection;
    Scanner scanner = new Scanner(System.in);


    public UserMenuCommands(Nursery nursery) {
        this.nursery = nursery;
    }


    /**
     * method of changing the animal parameters
     **/
    public void changePetFromNursery() {
        int id;
        int positionAnimalToAnimalList;

        String command;
        String name;
        Date birthday;

        while (true) {
            System.out.println("Input id Animal:");
            id = InputDataValidator.integerInput();
            positionAnimalToAnimalList = Nursery.searchPositionAnimalToAnimalList(id);
            if (positionAnimalToAnimalList != -1) {
                List<Animal> animalList = nursery.getAnimals();


                System.out.println("Select parameters of the pet to change: \n"
                        + animalList.get(positionAnimalToAnimalList));
                MenuTemplates.printMenuTitle("Parameters");

                if (true) {
                    // if (animalList.get(positionAnimalToAnimalList).getClass().toString().contains("Cat")) {
                    MenuTemplates.printMenuBody(
                            "1 - name\n" +
                                    "2 - birthday \n" +
                                    "3 - Species.\n" +
                                    "4 - Commands.\n" +
                                    "5 - Exit to main menu...");
                    MenuTemplates.printMenuLine();

                    userSelection = scanner.next();
                    if (userSelection.equals("1")) {
                        System.out.println("Input name: ");
                        name = scanner.next();
                        animalList.get(positionAnimalToAnimalList).setName(name);
                        System.out.println("name changed \n");
                    } else if (userSelection.equals("2")) {
                        birthday = inputBirthdayOfAnimal();
                        animalList.get(positionAnimalToAnimalList).setBirthday(birthday);
                        System.out.println("birthday changed \n");
                    } else if (userSelection.equals("3")) {
                        System.out.println("Input species: ");
                        String species = scanner.next();


                    } else if (userSelection.equals("4")) {
                        System.out.println("Input command for the pet: ");
                        command = scanner.next();
                        System.out.println("Do yoy want to add the command to the list or  overwrite list of commands for the pet?");
                        System.out.println("1 - Add \n2 - overwrite ");
                        int selectionInteger = InputDataValidator.integerInput();
                        if (selectionInteger == 1) {
                            animalList.get(positionAnimalToAnimalList).setNewCommand(command);
                            System.out.println("command added \n");
                        } else if (selectionInteger == 2) {
                            animalList.get(positionAnimalToAnimalList).deleteCommand();
                            animalList.get(positionAnimalToAnimalList).setNewCommand(command);
                            System.out.println("command is overwritten \n");
                        } else {
                            break;

                        }
                    } else if (userSelection.equals("5")) {
                        break;
                    } else {
                        System.out.println("input error, repeat the input");
                    }
                }

            } else {
                System.out.println("No such id exists! Input correct id!\n");
            }
        }
    }


    /**
     * method of entering the animal birthday
     **/

    public Date inputBirthdayOfAnimal() {
        System.out.println("Input birthday in the format dd-mm-yyyy:");
        String strDate = scanner.next();
        while (!InputDataValidator.isValidInputOfDate(strDate)) {
            System.out.println("Incorrect date format. Enter the date in the format dd-mm-yyyy:");
            strDate = scanner.next();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            //Parsing the String
            date = dateFormat.parse(strDate);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return date;
        }

    }


    /**
     * Method for adding a new commands for a newly created animal
     **/
    public List<String> addCommandsToNewAnimal() {
        List<String> ListOfCommands = new ArrayList<>();
        System.out.println("Do you want to input command for animal? y/n");
        if (scanner.next().equals("y")) {

            while (true) {

                System.out.println("Input command for animal");
                ListOfCommands.add(scanner.next());
                System.out.println("Continue entering the commands? y/n");
                if (!scanner.next().equals("y")) {
                    return ListOfCommands;
                }

            }
        } else {
            return ListOfCommands;
        }
    }

    /**
     * Method for adding a new commands for an existing animal
     **/

    public void addCommandsToExistAnimal() {


        int id;
        int positionAnimalToAnimalList;
        String newCommand;
        while (true) {
            System.out.println("Input id Animal:");
            id = InputDataValidator.integerInput();
            positionAnimalToAnimalList = Nursery.searchPositionAnimalToAnimalList(id);

            if (positionAnimalToAnimalList != -1) {
                List<Animal> animalList = nursery.getAnimals();


                System.out.println("Add command for: " + animalList.get(positionAnimalToAnimalList));
                scanner.nextLine();
                newCommand = scanner.nextLine();
                animalList.get(positionAnimalToAnimalList).setNewCommand(newCommand);

                System.out.println("Command added for animal id[" + id + "]\n");
                break;
            } else {
                System.out.println("No such id exists! Input correct id!\n");
                System.out.println("back to main menu?  y/n");
                if (scanner.next().equals("y")) {
                    break;
                }
            }
        }

    }

    /**
     * Pet nursery display method
     **/
    public void showPetNursery() {
        int id;
        List<Animal> animalList = nursery.getAnimals();
        if (animalList.isEmpty()) {

            MenuTemplates.printResponseTemplate("Pet nursery is empty");

        } else {
            System.out.println("1 - Display all pet nursery\n" +
                    "2 - Display the pet by ID");
            if (InputDataValidator.integerInput() == 1) {
                MenuTemplates.printMenuTitle("Composition of the pet nursery");
                for (Animal animal : animalList) {

                    System.out.println(animal.toString());
                }
                MenuTemplates.printMenuLine();
            } else {
                while (true) {
                    System.out.println("Input id Animal :");
                    id = InputDataValidator.integerInput();
                    int positionAnimalToAnimalList = Nursery.searchPositionAnimalToAnimalList(id);
                    if (positionAnimalToAnimalList != -1) {
                        System.out.println(nursery.getAnimals().get(positionAnimalToAnimalList));
                        System.out.println("go to the main menu? (y/n)");
                        if (scanner.next().equals("y")) {
                            break;
                        }
                    } else {
                        System.out.println("No such id exists! Input correct id!\n");
                    }
                }
            }
        }
        System.out.println("\n");
    }


    /**
     * Method for adding a new animal
     **/
    public void addNewAnimal() {


        String type;
        String name;
        Date birthday;
        int loadCapacity;
        int numberOfHumps;

        while (true) {
            MenuTemplates.printMenuTitle("Select pet category");
            MenuTemplates.printMenuBody("1 - Pet");
            MenuTemplates.printMenuBody("2 - Pack Animal");
            MenuTemplates.printMenuLine();

            userSelection = scanner.next();
            if (userSelection.equals("1")) {
                PetsEnum[] list = PetsEnum.values();

                MenuTemplates.printMenuTitle("Select the type of pet");
                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                }
                MenuTemplates.printMenuLine();
                type = scanner.next();
                if (type.equals("CAT")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input species: ");
                    String species = scanner.next();

                    Cat newCat = new Cat(name, birthday, species, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newCat);


                    MenuTemplates.printResponseTemplate("Animal added!");
                    break;
                }
                if (type.equals("DOG")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input species: ");
                    String species = scanner.next();
                    System.out.println("Input pedigree: ");
                    String pedigree = scanner.next();

                    Dog newDog = new Dog(name, birthday, species, pedigree, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newDog);


                    MenuTemplates.printResponseTemplate("Animal added!");

                    break;
                }
                if (type.equals("HAMSTER")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input species: ");
                    String species = scanner.next();
                    Hamster newHamster = new Hamster(name, birthday, species, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newHamster);
                    MenuTemplates.printResponseTemplate("Animal added!");
                    break;
                }
                MenuTemplates.printResponseTemplate("Error! Input correct value!");

            } else if (userSelection.equals("2")) {
                PackAnimalsEnum[] list = PackAnimalsEnum.values();
                MenuTemplates.printMenuTitle("Select the type of Pack animal:");

                for (int i = 0; i < list.length; i++) {
                    System.out.println(list[i]);
                }
                MenuTemplates.printMenuLine();
                type = scanner.next();
                if (type.equals("CAMEL")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input carrying capacity: ");
                    loadCapacity = InputDataValidator.integerInput();

                    System.out.println("Input number Of Humps: ");
                    numberOfHumps = InputDataValidator.integerInput();
                    Camel newCamel = new Camel(name, birthday, loadCapacity, numberOfHumps, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newCamel);
                    MenuTemplates.printResponseTemplate("Animal added!");
                    break;
                }
                if (type.equals("HORSE")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input carrying capacity: ");
                    loadCapacity = InputDataValidator.integerInput();

                    System.out.println("Input species: ");
                    String species = scanner.next();
                    Horse newHorse = new Horse(name, birthday, loadCapacity, species, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newHorse);
                    MenuTemplates.printResponseTemplate("Animal added!");
                    break;
                }
                if (type.equals("DONKEY")) {
                    System.out.println("Input name: ");
                    name = scanner.next();

                    birthday = inputBirthdayOfAnimal();

                    System.out.println("Input carrying capacity: ");
                    loadCapacity = InputDataValidator.integerInput();

                    System.out.println("Input species: ");
                    String species = scanner.next();
                    Donkey newDonkey = new Donkey(name, birthday, loadCapacity, species, addCommandsToNewAnimal());
                    nursery.addNewAnimal(newDonkey);
                    MenuTemplates.printResponseTemplate("Animal added!");
                    break;
                } else {
                    MenuTemplates.printResponseTemplate("Error! Input correct value!");
                }

            }
        }
        //scanner.close();
    }

    /**
     * pet removal method
     **/
    public void deletePetFromNursery() {
        int id;
        while (true) {
            System.out.println("Input id Animal:");
            id = InputDataValidator.integerInput();


            if (id >= 0 && id < nursery.getSizeOfAnimalList()) {
                List<Animal> animalList = nursery.getAnimals();
                System.out.println("Delete pet: " + animalList.get(id) + "\nfrom nursery?: y/n");
                if (scanner.next().equals("y")) {
                    animalList.remove(id);
                }


                System.out.println("Animal with id[" + id + "] deleted\n");
                break;
            } else {
                System.out.println("No such id exists! Input correct id!\n");
                System.out.println("back to main menu?  y/n");
                if (scanner.next().equals("y")) {
                    break;
                }
            }
        }
    }


}
