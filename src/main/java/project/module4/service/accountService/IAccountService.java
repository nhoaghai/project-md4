package project.module4.service.accountService;

import project.module4.dto.request.FormLogin;
import project.module4.dto.request.FormRegister;
import project.module4.model.Account;
import project.module4.service.IGenericService;

import java.util.List;

public interface IAccountService extends IGenericService<Account,Long> {
    void register(FormRegister formRegister);
    Account login(FormLogin formLogin);
    boolean checkExistByEmail(String email);
    boolean checkExistByPhone(String phoneNumber);
}
