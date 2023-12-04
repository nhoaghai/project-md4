package project.module4.dao.implement.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import project.module4.model.Account;

import java.util.List;

@Repository
public class AccountDao implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findByUserName(String userName) {
        String sql = "Select * from user where userName like ?";
        return jdbcTemplate.query(sql,new Object[]{userName}, rs -> {
            Account acc = null;
            if (rs.next()) {
                acc = new Account();
                acc.setUserId(rs.getLong("userId"));
                acc.setUserName(rs.getString("userName"));
                acc.setEmail(rs.getString("email"));
                acc.setFullName(rs.getString("fullName"));
                acc.setPassword(rs.getString("password"));
                acc.setRoll(rs.getBoolean("roll"));
                acc.setAddress(rs.getString("address"));
                acc.setPhoneNumber(rs.getString("phoneNumber"));
                acc.setStatus(rs.getBoolean("status"));
                acc.setCreateAt(rs.getDate("createAt"));
                acc.setUpdateAt(rs.getDate("updateAt"));
            }
            return acc;
        });
    }

    @Override
    public List<Account> findAll(int limit, int offset) {
        String sql = "select * from user limit " + limit + "offset " + offset + " ";
        List<Account> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Account acc = new Account();
            acc.setUserId(rs.getLong("userId"));
            acc.setUserName(rs.getString("userName"));
            acc.setEmail(rs.getString("email"));
            acc.setFullName(rs.getString("fullName"));
            acc.setPassword(rs.getString("password"));
            acc.setRoll(rs.getBoolean("roll"));
            acc.setAddress(rs.getString("address"));
            acc.setPhoneNumber(rs.getString("phoneNumber"));
            acc.setStatus(rs.getBoolean("status"));
            acc.setCreateAt(rs.getDate("createAt"));
            acc.setUpdateAt(rs.getDate("updateAt"));
            return acc;
        });
        return list;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from user";
        List<Account> list = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    Account acc = new Account();
                    acc.setUserId(rs.getLong("userId"));
                    acc.setUserName(rs.getString("userName"));
                    acc.setEmail(rs.getString("email"));
                    acc.setFullName(rs.getString("fullName"));
                    acc.setPassword(rs.getString("password"));
                    acc.setRoll(rs.getBoolean("roll"));
                    acc.setAddress(rs.getString("address"));
                    acc.setPhoneNumber(rs.getString("phoneNumber"));
                    acc.setStatus(rs.getBoolean("status"));
                    acc.setCreateAt(rs.getDate("createAt"));
                    acc.setUpdateAt(rs.getDate("updateAt"));
                    return acc;
                });
        return list;
    }

    @Override
    public Account findById(Long id) {
        String sql = "select * from user where userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public int save(Account account) {
        String sql = null;
        if (account.getUserId() == null) {
            //thêm mới
            sql = "insert into user(userName,password,email,fullName,createAt,updateAt) value(?,?,?,?,?,?)";
            return jdbcTemplate.update(sql, account.getUserName(), account.getPassword(), account.getEmail(), account.getFullName(), account.getCreateAt(), account.getUpdateAt());
        } else {
            //cập nhật
            sql = "update user set userName = ?, email = ?, fullName = ?, password = ?, address = ?, phoneNumber = ?, status = ?, updateAt = ?";
            return jdbcTemplate.update(sql, account.getUserName(), account.getEmail(), account.getFullName(), account.getPassword(), account.getAddress(), account.getPhoneNumber(), account.isStatus(), account.getUpdateAt());
        }
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from user where userId = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean checkExistByEmail(String email) {
        String sql = "select * from user where email = ?";
        List<Account> list = jdbcTemplate.query(sql, new Object[]{email},
                (rs, rowNum) -> {
                    Account account = new Account();
                    account.setEmail(rs.getString("email"));
                    return account;
                });
        return !list.isEmpty();
    }

    @Override
    public boolean checkExistByPhone(String phoneNumber) {
        String sql = "select * from user where phoneNumber = ?";
        List<Account> list = jdbcTemplate.query(sql, new Object[]{phoneNumber},
                (rs, rowNum) -> {
                    Account account = new Account();
                    account.setEmail(rs.getString("phoneNumber"));
                    return account;
                });
        return !list.isEmpty();
    }
}
