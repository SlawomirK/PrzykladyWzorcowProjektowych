package kreacyjne;

public class FabrykaAbstrakcyjna {
    public static void main(String[] args) {
        String system = "Linux";
        GUIFactory factory = null;
        if (system.equals("Windows")) {
            factory = new WindowsGUIFactory();
        } else {
            factory = new LinuxGUIFactory();
        }
        Button button=factory.createButton();
        Menu menu=factory.createMenu();

        System.out.println(button.getName());
        System.out.println(menu.getName());
    }

}

abstract class GUIFactory {
    abstract Button createButton();

    abstract Menu createMenu();
}

class WindowsGUIFactory extends GUIFactory {
    public Button createButton() {
        return new WindowsButton();

    }

    public Menu createMenu() {
        return new WindowsMenu();
    }
}

class LinuxGUIFactory extends GUIFactory {
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    Menu createMenu() {
        return new LinuxMenu();
    }

    public Menu CreateMenu() {
        return new LinuxMenu();
    }
}

abstract class Button {
    abstract String getName();
}

class WindowsButton extends Button {

    @Override
    String getName() {
        return "przycisk Widnows";
    }

}

class LinuxButton extends Button {

    @Override
    public String getName() {
        return "przycisk linux";
    }
}

abstract class Menu {
    abstract public String getName();
}

class WindowsMenu extends Menu {

    @Override
    public String getName() {
        return "Menu Widnows";
    }
}

class LinuxMenu extends Menu {
    public String getName() {
        return "LinuxMenu";
    }
}