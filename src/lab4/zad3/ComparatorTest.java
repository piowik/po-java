package lab4.zad3;

import java.util.LinkedList;

public class ComparatorTest {
    public static void main(String[] argv) {
        LinkedList<Pracownik> list = new LinkedList<>();
        list.add(new Pracownik(100.50f));
        list.add(new Pracownik(101.30f));
        list.add(new Pracownik(99.90f));
        list.add(new Pracownik(105.25f));
        list.add(new Pracownik(80.25f));
        System.out.println("Przed sortowaniem");
        printList(list);
        list.sort((o1, o2) -> {
            if (o1.brutto > o2.brutto) return 1;
            if (o1.brutto < o2.brutto) return -1;
            else return 0;
        });
        System.out.println("Po sortowaniu");
        printList(list);

    }

    private static void printList(LinkedList<Pracownik> list) {
        for (Pracownik p: list) {
            System.out.println(p.brutto);
        }
    }
}
