package strukturalne;
import java.util.ArrayList;
interface ComponentInterface {
    void process();
}

public class Kompozyt {
    public static void main(String[] args) {
        DesignPatternsComposite dpCom = new DesignPatternsComposite();
        dpCom.test();
    }
}

//
// Klasa liscia - definiuje objekty które nie mają dzieci
//
class Leaf implements ComponentInterface {

    @Override
    public void process() {
        System.out.println("Process: " + this);
    }
}

//
// Klasa kompozytu
//
class Composite implements ComponentInterface {

    private final ArrayList<ComponentInterface> children = new ArrayList<ComponentInterface>();

    public void addComponent(ComponentInterface child) {
        System.out.println("Add children: " + child);
        children.add(child);
    }

    @Override
    public void process() {
        if (!children.isEmpty()) {
            for (ComponentInterface child : children) {
                if (child instanceof ComponentInterface) {
                    child.process();
                }
            }
        }
    }
}

//
// Klasa klienta:
// tworzymy podstawowe obiekty, jeden kompozyt będzie zawierał dwa
// takie same obiekty liści
// testowo wykonujemy takie same operacje na stworzonych obiektach,
// widać ze niezależnie od punktu wejścia (liść, kompozyt czy cała struktura),
// wszystkie opracje wykonują się bez problemu
//
class DesignPatternsComposite {

    void test() {

        System.out.println("Add items ...");

        Leaf leaf = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();

        Composite childComposite = new Composite();
        Composite childComposite2 = new Composite();

        childComposite.addComponent(leaf);

        childComposite2.addComponent(leaf);
        childComposite2.addComponent(leaf2);
        childComposite2.addComponent(leaf3);

        Composite composite = new Composite();
        composite.addComponent(childComposite);
        composite.addComponent(childComposite2);

        System.out.println("Execute process on Leaf ...");

        leaf.process();
        leaf2.process();

        System.out.println("Execute process on Children ...");

        childComposite.process();
        childComposite2.process();

        System.out.println("Execute process on Composite ...");

        composite.process();
    }
}