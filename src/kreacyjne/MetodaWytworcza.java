package kreacyjne;

//MetodaWytworcza
interface Pojazd {
    String getNazwa();
}

interface FabrykaPojazdow {
    Pojazd budujPojazd(String nazwa);
}

class Rower implements Pojazd {
    private final String nazwa;

    public Rower(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return this.nazwa;
    }
}

class Samochod implements Pojazd {
    private final String nazwa;

    public Samochod(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class FabrykaRowerow implements FabrykaPojazdow {

    @Override
    public Rower budujPojazd(String nazwa) {
        return new Rower(nazwa);
    }
}

class FabrykaSamochodow implements FabrykaPojazdow {
    public static Pojazd tworzSamochod(String nazwa) {
        return new Samochod(nazwa);

    }

    @Override
    public Samochod budujPojazd(String nazwa) {
        return new Samochod(nazwa);
    }
}

class MetodaWytworcza {


    public static void main(String[] args) {
        FabrykaSamochodow fabrykaSamochodow = new FabrykaSamochodow();
        Samochod samochod = fabrykaSamochodow.budujPojazd("Ford");
        System.out.println(samochod.getNazwa());
    }


}