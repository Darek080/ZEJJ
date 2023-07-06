import java.util.Random;

public class CustomCheckedException extends Exception {
    private int number;

    public CustomCheckedException(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static void generateAndCheckNumber() throws CustomCheckedException {
        Random random = new Random();
        int generatedNumber = random.nextInt(10) + 1;

        if (generatedNumber % 2 == 0) {
            throw new CustomCheckedException("Wylosowano liczbę parzystą!", generatedNumber);
        }

        System.out.println("Wylosowano liczbę nieparzystą: " + generatedNumber);
    }
}