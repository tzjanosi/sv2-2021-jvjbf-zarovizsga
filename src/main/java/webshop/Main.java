package webshop;

import org.mariadb.jdbc.MariaDbDataSource;

public class Main {
    public static void main(String[] args) {
        DBSource dbSource= new DBSource("/webshop.properties");
        MariaDbDataSource dataSource= dbSource.getDataSource();

        ProductRepository personDao=new ProductRepository(dataSource);

    }
}
