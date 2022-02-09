package lastOne;

import java.util.LinkedList;

public class PrintMethod {
    public static void printM(LinkedList<Section> a,LinkedList<Section> b, LinkedList<Section> c) {
        for (Section s : a) {
            System.out.println("Czytanie z dysku plikow z przedzialu:" + s);

        }
        for (Section s : b) {
            System.out.println("Wykorzystanie wczytanego przedzialu:" + s);

        }
        System.out.println("W pamieci trzymane sa teraz przedzialy:");
        for (Section s : c) {
            System.out.println(s);
        }
    }
}
