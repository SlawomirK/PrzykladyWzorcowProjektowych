package strukturalne;

interface AbstrakcyjnyIF {
    void action();
}

interface ImplementatorIF {
    void actionImplementowana();
}

public class Most {
    public static void main(String[] args) {

    }
}

class AutoSportoweImplementator implements ImplementatorIF {
    public AutoSportoweImplementator() { /*ciało konstruktora*/ }

    public void actionImplementowana() { /*ciało metody*/ }
}

class AutoRodzinneImplementator implements ImplementatorIF {
    public AutoRodzinneImplementator() { /*ciało konstruktora*/ }

    public void actionImplementowana() { /*ciało metody*/ }
}

class AutoSportowe implements AbstrakcyjnyIF {
    ImplementatorIF implementator = new AutoSportoweImplementator();

    public AutoSportowe() { /*ciało konstruktora*/ }

    public void action() {
        implementator.actionImplementowana();
    }
}

class AutoRodzinne implements AbstrakcyjnyIF {
    ImplementatorIF implementator = new AutoRodzinneImplementator();

    public AutoRodzinne() { /*ciało konstruktora*/ }

    public void action() {
        implementator.actionImplementowana();
    }
}