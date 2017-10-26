package lab4.zad1;

import lab1.JIn;
import lab3.zad4.Kolo;
import lab3.zad4.Kwadrat;
import lab3.zad4.Shape;
import lab3.zad4.Trojkat;

import java.util.LinkedList;

public class ShapeProgram {    public static void main(String[] argv) {
    LinkedList<Shape> shapes = new LinkedList<>();
    int opcja = 0;

    while (opcja != 5) {
        System.out.println("MENU GLOWNE");
        System.out.println("1. dodaj kwadrat");
        System.out.println("2. dodaj trojkat");
        System.out.println("3. dodaj kolo");
        System.out.println("4. Wyswietl");
        System.out.println("5. Wyjdz");
        System.out.print("Wybierz opcje: ");
        opcja = JIn.getInteger();
        switch (opcja) {
            case 1:
                shapes.add(new Kwadrat());
                System.out.println("Dodano");
                break;
            case 2:
                shapes.add(new Trojkat());
                System.out.println("Dodano");
                break;
            case 3:
                shapes.add(new Kolo());
                System.out.println("Dodano");
                break;
            case 4:
                for (Shape s : shapes) {
                    s.draw();
                }
                break;
            case 5:
                System.out.println("Zegnaj");
                break;
        }
    }
}

}
