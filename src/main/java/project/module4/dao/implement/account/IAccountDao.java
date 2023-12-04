package project.module4.dao.implement.account;

import project.module4.dao.IGenericDao;
import project.module4.model.Account;

import java.util.List;

public interface IAccountDao extends IGenericDao<Account, Long> {
    Account findByUserName(String userName);
    boolean checkExistByEmail(String email);
    boolean checkExistByPhone(String phoneNumber);
}
