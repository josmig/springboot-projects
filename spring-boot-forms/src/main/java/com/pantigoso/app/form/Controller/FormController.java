package com.pantigoso.app.form.Controller;

import com.pantigoso.app.form.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

	//Metodos handler GET / POST
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();

		usuario.setIdentificador("123.4523.231");
		usuario.setNombre("Miguel");
		usuario.setApellido("Pantigoso");
		model.addAttribute("user",usuario);
		model.addAttribute("title","Formulario usuario");
		return "form";
	}
	
	@PostMapping("/form")
	public String procesoFormulario(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model) {
		model.addAttribute("title","Resultado del formulario");

		//binding es cuando falla la validacion para saber eso
		if(result.hasErrors()){
			/*
			//obteniendo el mensaje de error
			Map<String ,String> errores = new HashMap<>();
			//Forma manual de obtener los errores de BindingResult
				//getFiledErrors nos crea un arrelgo y lo recorremos
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error",errores);*/
			return "form";
		}

		model.addAttribute("usuario",usuario);
		return "resultado";		
	}
	
}
