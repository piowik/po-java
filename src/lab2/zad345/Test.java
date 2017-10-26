package lab2.zad345;

import lab1.JIn;

import java.util.LinkedList;

public class Test {
    public static void main(String[] argv) {
        int menu = 0;
        LinkedList<Punkt3D> punkty = new LinkedList<>();
        while (menu != 4) {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyświetl wszystkie punkty");
            System.out.println("3. Oblicz odległość");
            System.out.println("4. Zakończ");
            System.out.print("Wybierz opcje: ");
            menu = JIn.getInteger();
            switch (menu) {
                case 1:
                    int x, y, z;
                    System.out.print("X: ");
                    x = JIn.getInteger();
                    System.out.print("Y: ");
                    y = JIn.getInteger();
                    System.out.print("Z: ");
                    z = JIn.getInteger();
                    punkty.add(new Punkt3D(x, y, z));
                    System.out.println("OK");
                    break;

                case 2:
                    if (punkty.size() == 0)
                        System.out.println("Brak punktów");
                    else {
                        listPoints(punkty);
                    }
                    break;

                case 3:
                    int a, b;
                    listPoints(punkty);
                    System.out.print("Wybierz punkt A: ");
                    a = JIn.getInteger();
                    System.out.print("Wybierz punkt B: ");
                    b = JIn.getInteger();
                    System.out.println("Odleglosc: " + punkty.get(a).distance(punkty.get(b)));
                    break;
            }
        }
    }

    private static void listPoints(LinkedList<Punkt3D> punkty) {
        for (int i = 0; i < punkty.size(); i++) {
            Punkt3D p = punkty.get(i);
            System.out.println(i + ": [" + p.getX() + ", " + p.getY() + ", " + p.getZ() + "]");
        }
    }
}