package com.pantigoso.app.form.Validation;

import com.pantigoso.app.form.Model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        //aca indicamos que clase pojo / entity vamos a validar

        return Usuario.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario  = (Usuario)target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nombre","NotEmpty.user.nombre");

        if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") == false){
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }
    }
}
