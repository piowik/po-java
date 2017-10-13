package lab1;

public class PeselProgram {
    public static void main(String[] argv) {
        System.out.print("Pesel: ");
        String peselInput = JIn.getString();
        if (Pesel.check(peselInput))
            System.out.print("OK");
        else
            System.out.print("nie OK");
    }
}
