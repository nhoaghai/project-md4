package project.module4.dao.implement.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project.module4.model.Product;

import java.util.List;

@Repository
public class ProductDao implements IProductDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Product> findAll(int limit, int offset) {
        String sql = "select * from product limit " + limit + "offset" + offset + "";
        List<Product> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getLong("catalogId"));
            product.setProductName(rs.getString("catalogName"));
            product.setDescription(rs.getString("description"));
            product.setUnitPrice(rs.getDouble("unitPrice"));
            product.setStock(rs.getInt("stock"));
            return product;
        });
        return list;
    }

    @Override
    public List<Product> findAll() {
        String sql = "select * from product";
        List<Product> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product product = new Product();
            product.setProductId(rs.getLong("catalogId"));
            product.setProductName(rs.getString("catalogName"));
            product.setCategoryId(rs.getLong("categoryId"));
            product.setDescription(rs.getString("description"));
            product.setUnitPrice(rs.getDouble("unitPrice"));
            product.setStock(rs.getInt("stock"));
            return product;
        });
        return list;
    }

    @Override
    public Product findById(Long id) {
        String sql = "select * from product where productId = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public int save(Product product) {
        String sql =null;
        if (product.getProductId() == null){
            //them moi
            sql = "insert into product(productName, description, unitPrice, stock, createAt, updateAt) value (?,?,?,?,?,?)";
            return jdbcTemplate.update(sql,product.getProductName(), product.getDescription(), product.getUnitPrice(), product.getStock(), product.getCreateAt(), product.getUpdateAt());
        }else {
            //cap nhat
            sql = "update product set productName = ?, description = ?, unitPrice = ?, stock = ?, updateAt = ?, status = ?";
            return jdbcTemplate.update(sql,product.getProductName(), product.getDescription(),product.getUnitPrice(), product.getStock(), product.getUpdateAt(), product.isStatus());
        }

    }

    @Override
    public int delete(Long id) {
        String sql = "delete product where productId = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int deleteAll(Long categoryId) {
        String sql = "delete * product where categoryId = ?";
        return jdbcTemplate.update(sql, categoryId);
    }
}
