package czynnosciowe;

public class MetodaSzablonowa {
    public static void main(String[] args) {
        var mysqlQuery = new MySQLQuerry();
        mysqlQuery.getDataFromDB();
        var mongoDBQuerry = new MongoDBQuery();
        mongoDBQuerry.getDataFromDB();
    }
}

abstract class DatabaseQuerry {
    abstract void prepareQuery();

    abstract void sendQuery();

    abstract void getResult();

    final public void getDataFromDB() {
        this.prepareQuery();
        this.sendQuery();
        this.getResult();
    }
}

class MySQLQuerry extends DatabaseQuerry {

    @Override
    void prepareQuery() {
        System.out.println("Przygotowuje zapytanie do bazy MySQL");
    }

    @Override
    void sendQuery() {
        System.out.println("wysylam zapytanie do bazy MySQL");

    }

    @Override
    void getResult() {
        System.out.println("odbieran dane z bazy MySQL");

    }
}

class MongoDBQuery extends DatabaseQuerry {

    @Override
    void prepareQuery() {
        System.out.println("Przygotowuje zapytanie do bazy MongoDB");
    }

    @Override
    void sendQuery() {
        System.out.println("Wysylam zapytanine do bazy MongoDB");

    }

    @Override
    void getResult() {
        System.out.println("Odbieram dane z bazy MongoDB");
    }
}