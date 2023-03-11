package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputDataValidator {

    /**
     * method for checking the date input format
     **/

    public static boolean isValidInputOfDate(String text) {
        if (text == null || !text.matches("\\d{2}-\\d{2}-\\d{4}"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        try {
            df.parse(text);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }


    /**
     * method to validate integer input
     **/
    public static int integerInput() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("Error! Enter an integer!");
            scanner.next();
        }
        return scanner.nextInt();
    }


}
