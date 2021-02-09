package czynnosciowe;

import java.util.Arrays;
import java.util.List;

interface SortStrategy<E> {
    List<E> sort(List<E> list);
}

public class Strategia {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        var sorttingComponent = new SortingComponent(new BucketSortStrategy());
        sorttingComponent.sortList(list);
        sorttingComponent = new SortingComponent(new QuickSortStrategy());
        sorttingComponent.sortList(list);
    }
}

class QuickSortStrategy implements SortStrategy {

    @Override
    public List sort(List list) {
        System.out.println("Lista posortowana Quick sort");
        return list;
    }
}

class BucketSortStrategy implements SortStrategy {

    @Override
    public List sort(List list) {
        System.out.println("Lista posortowana za pomocą Bucket sort");
        return list;
    }
}

class InsertionSortStrategy implements SortStrategy {

    @Override
    public List sort(List list) {
        System.out.println("Lista posortowana za pomocą insertion sort");
        return list;
    }
}

class SortingComponent {
    private final SortStrategy sortStrategy;

    public SortingComponent(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public List sortList(List list) {
        return this.sortStrategy.sort(list);
    }
}