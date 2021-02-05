package kreacyjne;

public class Budowniczy {
    public static void main(String[] args) {
        Pizza pizza = (new PizzaBuilder("Mała")).dodajPomidor().dodajEkstraSer().build();
        System.out.println(pizza);
    }

}

class Pizza {
    protected String rozmiar;
    protected boolean pomidor;
    protected boolean ekstraSer = false;
    protected boolean bekon = false;

    public Pizza(PizzaBuilder pizzaBuilder) {
        this.rozmiar = pizzaBuilder.rozmiar;
        this.pomidor = pizzaBuilder.pomidor;
        this.ekstraSer = pizzaBuilder.ekstraSer;
        this.bekon = pizzaBuilder.bekon;

    }

    @Override
    public String toString() {
        return "Pizza{" +
                "rozmiar='" + rozmiar + '\'' +
                ", pomidor=" + pomidor +
                ", ekstraSer=" + ekstraSer +
                ", bekon=" + bekon +
                '}';
    }
}

class PizzaBuilder {
    public String rozmiar;
    public boolean pomidor = false;
    public boolean ekstraSer = false;
    public boolean bekon = false;

    public PizzaBuilder(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public PizzaBuilder dodajPomidor() {
        this.pomidor = true;
        return this;
    }

    public PizzaBuilder dodajEkstraSer() {
        this.ekstraSer = true;
        return this;
    }

    public PizzaBuilder dodajBekon() {
        this.bekon = true;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }

}
