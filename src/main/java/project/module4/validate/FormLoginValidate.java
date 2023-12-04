package project.module4.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import project.module4.dto.request.FormLogin;

@Component
public class FormLoginValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return FormLogin.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormLogin formLogin = (FormLogin) target;
        if (formLogin.getUserName().isEmpty()){
            errors.rejectValue("userName","form-login.email.empty","userName is not empty");
//        }else if(!formLogin.getUserName().matches("^(.+)@(\\S+)$")){
//            errors.rejectValue("userName","form-login.email.invalid","userName is invalid");
        }
        if (formLogin.getPassword().isEmpty()){
            errors.rejectValue("password","form-login.password.empty","rePassword is empty");
        }

    }
}
