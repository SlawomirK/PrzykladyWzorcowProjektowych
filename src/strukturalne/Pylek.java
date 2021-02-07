package strukturalne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Pylek {
    public static void main(String[] args) {
        InventorySystem inventorySystem = new InventorySystem();

        inventorySystem.takeOrder("TV Samsung", 121);
        inventorySystem.takeOrder("Lodówka Samsung", 399);
        inventorySystem.takeOrder("Smartfon Motorola", 171);
        inventorySystem.takeOrder("Aparat Nikon", 12);
        inventorySystem.takeOrder("Słuchawki Bluetooth", 121);

        inventorySystem.takeOrder("TV Samsung", 134);
        inventorySystem.takeOrder("Lodówka Samsung", 151);
        inventorySystem.takeOrder("Smartfon Motorola", 34);
        inventorySystem.takeOrder("Aparat Nikon", 85);
        inventorySystem.takeOrder("Słuchawki Bluetooth", 1296);

        inventorySystem.takeOrder("TV Samsung", 3401);
        inventorySystem.takeOrder("Lodówka Samsung", 13);
        inventorySystem.takeOrder("Smartfon Motorola", 454);
        inventorySystem.takeOrder("Aparat Nikon", 442);
        inventorySystem.takeOrder("Słuchawki Bluetooth", 921);

        inventorySystem.process();

        System.out.println(inventorySystem.report());
        // Wszystkich obiektów: 5
    }
}

class InventorySystem {
    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<>();

    public void takeOrder(String itemName, int orderNumber) {
        Item item = catalog.lookup(itemName);
        Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    public void process() {
        for (Order order : orders) {
            order.processOrder();
        }
    }

    public String report() {
        return "Wszystkich obiektów: " + catalog.totalItemsMade();
    }
}

class Catalog {
    private final Map<String, Item> items = new HashMap<>();

    public Item lookup(String itemName) {
        if (!items.containsKey(itemName)) {
            items.put(itemName, new Item(itemName));
        }
        return items.get(itemName);
    }

    public int totalItemsMade() {
        return items.size();
    }
}

class Order {
    private final int orderNumber;
    private final Item item;

    public Order(int orderNumber, Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    public void processOrder() {
        System.out.println("Pozycja:" + item + "ilość:" + orderNumber);
    }
}

class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
