package czynnosciowe;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfejs wzorca iteraotr
 */
interface Iterator<E> {
    boolean hasNext();

    E next();
}

public class Wzorzec_Iterator {

    private static final Integer[] intArray = new Integer[10];
    private static final ArrayList<Integer> intList = new ArrayList<Integer>();

    public static void main(String[] args) {

        //
        // Dodanie danych do tablicy
        //
        intArray[0] = 1;
        intArray[1] = 11;
        intArray[2] = 21;
        intArray[3] = 31;
        intArray[4] = 41;
        intArray[5] = 51;
        intArray[6] = 61;
        intArray[7] = 71;
        intArray[8] = 81;
        intArray[9] = 91;

        //
        // Dodanie danych do listy
        //
        intList.add(1);
        intList.add(11);
        intList.add(21);
        intList.add(31);
        intList.add(41);
        intList.add(51);
        intList.add(61);
        intList.add(71);
        intList.add(81);

        //
        // Wyświetlanie zawartości przy pomocy iteratora
        // metoda wymaga klas implementujących interfejs iterator,
        // który zapewnia usystematyzowany dostęp do danych
        //
        printData(new ArrayIterator(intArray), "Tablica");
        printData(new ListIterator(intList), "Lista");
    }

    /**
     * Drukowanie zawartości kolekcji
     *
     * @param iterator
     * @param info
     */
    private static void printData(Iterator iterator, String info) {

        if (iterator != null) {

            System.out.println("Dane: " + info);
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + ", ");
            }
            System.out.println();
            System.out.println();
        }
    }
}

/**
 * Klasa obsługująca dostęp do danych zawartych w tablicy
 */
class ArrayIterator<E> implements Iterator {

    int posistion = 0;
    E[] items;

    public ArrayIterator(E[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return posistion < items.length && items[posistion] != null;
    }

    @Override
    public E next() {
        E item = items[posistion];
        posistion++;
        return item;
    }
}

/**
 * Klasa obsługująca dostęp do danych zawartych w liście
 */
class ListIterator<E> implements Iterator {

    int posistion = 0;
    List<E> items;

    public ListIterator(List<E> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return posistion < items.size() && items.get(posistion) != null;
    }

    @Override
    public E next() {
        E item = items.get(posistion);
        posistion++;
        return item;
    }
}