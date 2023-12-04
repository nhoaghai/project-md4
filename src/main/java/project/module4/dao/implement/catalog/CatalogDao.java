package project.module4.dao.implement.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project.module4.model.Catalog;

import java.util.List;

@Repository
public class CatalogDao implements ICatalogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Catalog> findAll(int limit, int offset) {
        String sql = "select * from catalog limit " + limit + "offset" + offset + "";
        List<Catalog> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Catalog catalog = new Catalog();
            catalog.setCatalogId(rs.getLong("catalogId"));
            catalog.setCatalogName(rs.getString("catalogName"));
            catalog.setDescription(rs.getString("description"));
            return catalog;
        });
        return list;
    }

    @Override
    public List<Catalog> findAll() {
        String sql = "select * from catalog";
        List<Catalog> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Catalog catalog = new Catalog();
            catalog.setCatalogId(rs.getLong("catalogId"));
            catalog.setCatalogName(rs.getString("catalogName"));
            catalog.setDescription(rs.getString("description"));
            return catalog;
        });
        return list;
    }

    @Override
    public Catalog findById(Long id) {
        String sql = "select * from catalog where catalogId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Catalog.class));
    }

    @Override
    public int save(Catalog catalog) {
        String sql = null;
        if (catalog.getCatalogId() == null) {
            //them moi
            sql = "Insert into catalog(catalogName, description,createAt) value(?,?,?)";
            return jdbcTemplate.update(sql, catalog.getCatalogName(), catalog.getDescription(), catalog.getCreateAt());
        } else {
            //cap nhat
            sql = "update catalog set catalogName = ?, description = ? where  id = ?";
            return jdbcTemplate.update(sql, catalog.getCatalogName(), catalog.getDescription(), catalog.getCatalogId());
        }
    }

    @Override
    public int delete(Long id) {
        String sql = "Delete from catalog where catalogId = ?";
        return jdbcTemplate.update(sql, id);
    }
}
