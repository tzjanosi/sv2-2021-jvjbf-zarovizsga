package webshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import javax.sql.DataSource;
import java.sql.Types;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(DataSource dataSource) {
        jdbcTemplate =new JdbcTemplate(dataSource);
    }

    public void updateProductStock(long id, int amount){
        jdbcTemplate.update("UPDATE products SET stock=stock-? WHERE id=?",amount,id);
    }

    public Product findProductById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?", new ProductMapper(),id);
    }

    public long insertProduct(String productName, int price, int stock){

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO products (product_name,price,stock) VALUES(?,?,?);";
        PreparedStatementCreatorFactory statementCreatorFactory = new PreparedStatementCreatorFactory(sql, Types.VARCHAR,Types.INTEGER, Types.INTEGER);
        statementCreatorFactory.setReturnGeneratedKeys(true);
        statementCreatorFactory.setGeneratedKeysColumnNames("id");
        PreparedStatementCreator preparedStatementCreator = statementCreatorFactory.newPreparedStatementCreator(new Object[]{productName, price, stock});
        jdbcTemplate.update(preparedStatementCreator,keyHolder);
        return keyHolder.getKey().longValue();
    }
}
