package czynnosciowe;

public class Memento {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.sum(3, 3);
        var saved = calculator.saveResult();
        System.out.println("Pierwszy wynik: " + calculator.getResult());
        calculator.sum(2, 7);
        System.out.println("Bieżący wynik: " + calculator.getResult());
        calculator.restoreResult(saved);
        System.out.println("Poprzedni wynik: " + calculator.getResult());
    }
}

class CalculatorMemento {
    protected int result;

    public CalculatorMemento(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}

class Calculator {
    protected int result;

    public void sum(int a, int b) {
        this.result = a + b;
    }

    public int getResult() {
        return this.result;
    }

    public CalculatorMemento saveResult() {
        return new CalculatorMemento(this.result);
    }

    public void restoreResult(CalculatorMemento memento) {
        this.result = memento.getResult();
    }
}