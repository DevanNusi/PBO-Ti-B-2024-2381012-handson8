import config.Database;
public class Main {
    public static void main(String[] args) {
        Database database = new Database("my_db", "root", "", "localhost", "3306");
        database.setup();
    }
}