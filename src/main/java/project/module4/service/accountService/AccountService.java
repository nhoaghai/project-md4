package project.module4.service.accountService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.module4.dao.implement.account.IAccountDao;
import project.module4.dto.request.FormLogin;
import project.module4.dto.request.FormRegister;
import project.module4.model.Account;

import java.util.List;
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Override
    public List<Account> findAll(int page, int size) {
        return accountDao.findAll(size,page*size);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public void register(FormRegister formRegister) {
        Account account = new Account(formRegister.getUserName(),
                formRegister.getEmail(),
                BCrypt.hashpw(formRegister.getPassword(),BCrypt.gensalt(12)),
                formRegister.getAddress(),
                formRegister.getPhoneNumber());
        accountDao.save(account);
    }

    @Override
    public Account login(FormLogin formLogin) {
        Account account = accountDao.findByUserName(formLogin.getUserName());
        if (account != null && BCrypt.checkpw(formLogin.getPassword(),account.getPassword())){
            return account;
        }
        return null;
    }

    @Override
    public int delete(Long id) {
        return accountDao.delete(id);
    }

    @Override
    public boolean checkExistByEmail(String email) {
         return accountDao.checkExistByEmail(email);

    }

    @Override
    public boolean checkExistByPhone(String phoneNumber) {
        return accountDao.checkExistByPhone(phoneNumber);
    }
}
