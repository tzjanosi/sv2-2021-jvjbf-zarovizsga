package webshop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product(
                rs.getInt("id"),
                rs.getString("product_name"),
                rs.getInt("price"),
                rs.getInt("stock") );
        return product;
    }
}
