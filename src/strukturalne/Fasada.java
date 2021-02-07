package strukturalne;

public class Fasada {
    public static void main(String[] args) {
        OrderFacade order = new OrderFacade();
        System.out.println(order.PrepareOrder());
    }


}

class Produkt {
    public String getProdukt() {
        return "Produkt";
    }
}

class Payment {
    public boolean makePayment() {
        return true;
    }
}

class Customer {
    public String getCustomerData() {
        return "Dane zamawiajacego";
    }
}

class OrderFacade {
    protected Produkt produkt;
    protected Payment payment;
    protected Customer customer;

    public OrderFacade() {
        this.produkt = new Produkt();
        this.payment = new Payment();
        this.customer = new Customer();
    }

    public String PrepareOrder() {
        System.out.println(this.produkt.getProdukt());
        System.out.println(this.payment.makePayment());
        System.out.println(this.customer.getCustomerData());
        return "Zamowienie przygotowane";
    }

}