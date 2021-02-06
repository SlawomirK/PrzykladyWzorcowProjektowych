package strukturalne;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class Dekorator {
    public static void main(String[] args) {
        Pizza margherita = new Pizza();
        Pizza withMozzarella = new PizzaWithMozzarella(margherita);
        Pizza withMozzarellaAndHam = new PizzaWithHam(withMozzarella);
        Pizza withMozzarellaHamAndBasil = new PizzaWithBasil(withMozzarellaAndHam);

        DecimalFormat df = new DecimalFormat("#,00 zł");
        for (Pizza pizza : List.of(margherita, withMozzarella, withMozzarellaAndHam, withMozzarellaHamAndBasil)) {
            System.out.println(String.format("%s costs %s.", pizza, df.format(pizza.getPrice())));
        }
    }
}

class Pizza {
    private static final BigDecimal PRICE = new BigDecimal(12);

    public BigDecimal getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class PizzaWithBasil extends Pizza {
    private static BigDecimal PRICE;
    private final Pizza basePizza;

    public PizzaWithBasil(Pizza bazePizza) {
        this.basePizza = bazePizza;
        PRICE = new BigDecimal(String.valueOf(bazePizza.getPrice().add(BigDecimal.valueOf(4))));
    }

    @Override
    public BigDecimal getPrice() {
        return PRICE;
    }
}

class PizzaWithHam extends Pizza {
    private static BigDecimal PRICE;
    private final Pizza basePizza;

    public PizzaWithHam(Pizza bazePizza) {
        this.basePizza = bazePizza;
        PRICE = new BigDecimal(String.valueOf(bazePizza.getPrice().add(BigDecimal.valueOf(6))));

    }

    @Override
    public BigDecimal getPrice() {
        return PRICE;
    }
}

class PizzaWithMozzarella extends Pizza {
    private static BigDecimal PRICE;
    private final Pizza basePizza;

    public PizzaWithMozzarella(Pizza basePizza) {
        this.basePizza = basePizza;
        PRICE = new BigDecimal(String.valueOf(basePizza.getPrice().add(BigDecimal.valueOf(7))));

    }

    @Override
    public BigDecimal getPrice() {
        return PRICE;
    }
}