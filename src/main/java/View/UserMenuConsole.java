package View;

import Models.Nursery;
import Repository.LoadFromFile;
import Repository.WriteToFile;

import java.io.IOException;
import java.util.Scanner;

public class UserMenuConsole {
    private String userSelection;
    private Nursery nursery;


    Scanner scanner = new Scanner(System.in);

    public UserMenuConsole(Nursery nursery) {
        this.nursery = nursery;
    }



    /**
     * method of user interaction with the main menu
     **/
    public void start() throws IOException {
        UserMenuCommands userMenuCommands = new UserMenuCommands(nursery);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MenuTemplates.printMenuTitle("Main menu: Select a item:");
            MenuTemplates.printMenuBody(
                    "1 - Show pet nursery.\n" +
                            "2 - Add new pet in to the nursery \n" +
                            "3 - Add new command for the pet.\n" +
                            "4 - Change data of the pet from nursery.\n" +
                            "5 - Delete pet from nursery.\n" +
                            "6 - Exit without overwriting of the nursery data file \n" +
                            "7 - Exit and overwrite the nursery data file ");
            MenuTemplates.printMenuLine();


            userSelection = scanner.next();

            if (userSelection.equals("1")) {
                userMenuCommands.showPetNursery();
            } else if (userSelection.equals("2")) {
                userMenuCommands.addNewAnimal();
            } else if (userSelection.equals("3")) {
                userMenuCommands.addCommandsToExistAnimal();

            } else if (userSelection.equals("4")) {
                userMenuCommands.changePetFromNursery();

            } else if (userSelection.equals("5")) {
                userMenuCommands.deletePetFromNursery();

            } else if (userSelection.equals("6")) {
                System.out.println("program completed");
                break;

            } else if (userSelection.equals("7")) {
                WriteToFile file = new WriteToFile();

                file.writeToFile(nursery);
                System.out.println("All changes are saved in the file\nProgram completed");

                break;


            }else {
                MenuTemplates.printResponseTemplate("Error! Input correct value!");

            }

        }
    }
}

