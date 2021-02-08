package czynnosciowe;

public class LancuchOdpowiedzialnosci {
    public static void main(String[] args) {
        var pp = new PayPal();
        var br = new BankTransfer();
        var cc = new CreditCard();
        pp.setSuccessor(br);
        br.setSuccessor(cc);
        System.out.println("Metoda platnosci " + pp.processPayment(4500).getClass().getSimpleName());
        System.out.println("Metoda platnosci " + pp.processPayment(50).getClass().getSimpleName());
        System.out.println("Metoda platnosci " + pp.processPayment(99).getClass().getSimpleName());
    }
}

abstract class PaymentProcessor {
    protected PaymentProcessor successor = null;

    public void setSuccessor(PaymentProcessor successor) {
        this.successor = successor;
    }

    abstract public PaymentProcessor processPayment(int amount);

}

class PayPal extends PaymentProcessor {

    public PaymentProcessor processPayment(int amount) {
        if (amount >= 0 && amount <= 99) {
            System.out.println("Platnosc PayPal:" + amount);
        } else {
            if (this.successor != null)
                return this.successor.processPayment(amount);
        }
        return this;
    }
}

class BankTransfer extends PaymentProcessor {


    @Override
    public PaymentProcessor processPayment(int amount) {
        if (amount >= 100 && amount <= 99) {
            System.out.println("Platnosc Przelew: " + amount);
        } else {
            if (this.successor != null)
                return this.successor.processPayment(amount);
        }
        return this;
    }
}

class CreditCard extends PaymentProcessor {

    @Override
    public PaymentProcessor processPayment(int amount) {
        if (amount >= 1000) {
            System.out.println("Platnosc kartą: " + amount);
        } else {
            if (this.successor != null)
                return this.successor.processPayment(amount);
        }
        return this;
    }
}