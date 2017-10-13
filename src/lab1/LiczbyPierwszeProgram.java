package lab1;

public class LiczbyPierwszeProgram {
    public static void main(String[] argv) {
        System.out.print("Podaj do jakiej liczby szukac liczb pierwszych: ");
        int target = JIn.getInteger();
        int[] result = LiczbyPierwsze.find(target);
        System.out.print("Liczby pierwsze: ");
        for (int i=2; i<target; i++) {
            if (result[i] != 0) {
                if (i != 2)
                    System.out.print(", ");
                System.out.print(i);
            }
        }
    }
}     