package czynnosciowe;

interface Command {
    void wykonaj();
}

public class Polecenie {
    public static void main(String[] args) {
        Silnik silnik = new Silnik();
        Przelacznik przelacznik = new Przelacznik();
        WlaczSilnik wlaczSilnik = new WlaczSilnik(silnik);
        WylaczSilnik wylacz = new WylaczSilnik(silnik);
        przelacznik.przelacz(wlaczSilnik);
        przelacznik.przelacz(wylacz);

    }
}

class Silnik {//np silnik

    public void wlacz() {
        System.out.println("Silnik wlaczony");
    }

    public void wylacz() {
        System.out.println("Silnik wylaczony");
    }
}

class WlaczSilnik implements Command {
    private final Silnik silnik;

    public WlaczSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    @Override
    public void wykonaj() {
        this.silnik.wlacz();
    }
}

class WylaczSilnik implements Command {
    private final Silnik silnik;

    public WylaczSilnik(Silnik silnik) {
        this.silnik = silnik;
    }

    public void wykonaj() {
        this.silnik.wylacz();
    }
}

class Przelacznik {
    public void przelacz(Command komenda) {
        komenda.wykonaj();
    }
}