package Service;

public class Counter {
    private static int id;

    /**
     * counter for creating an automatic id
     **/
    public int add() {
        return id++;
    }
}