public class Assignment01Q01 {
    public static void main(String[] args) {
        for (String string : args) {
            char c = string.charAt(0);
            if (((int) c) % 5 == 0) {
                System.out.println(c);
            }
        }
    }
}
