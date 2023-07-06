public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String nullString = null;
        try {
            System.out.println(nullString.length());
        } catch (NullPointerException e) {
            System.out.println("Wyjątek NullPointerException");
        }
    }
}