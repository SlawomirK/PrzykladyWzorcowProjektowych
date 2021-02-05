package kreacyjne;

public class Singelton {
    public static void main(String[] args) {
        DbConnection con1 = DbConnection.getInstance();
        DbConnection con2 = DbConnection.getInstance();
        System.out.println(con1.equals(con2));

    }
}

final class DbConnection {
    private static DbConnection INSTANCE;

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DbConnection();
        }
        return INSTANCE;
    }
}
