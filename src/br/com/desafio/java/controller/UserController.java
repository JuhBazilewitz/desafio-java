package br.com.desafio.java.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.desafio.java.dao.UserDao;
import br.com.desafio.java.model.User;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserDao dao;

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("user", "user", new User());
    }

    @RequestMapping(value = "/novoUsuario", method = RequestMethod.POST)
    public String salvar(@Validated @ModelAttribute("user") User usuario, BindingResult result, ModelMap model)
            throws ParseException {
        if (result.hasErrors()) {
            return "error";
        }
        usuario.setRegisterDate(convertDate());
        save(usuario);
        getModelMap(model, usuario);
        return "sucesso";
    }

    private String convertDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String format = formatter.format(date);
        return format;
    }

    private void save(User usuario) {
        dao.salvar(usuario);
    }

    private ModelMap getModelMap(ModelMap model, User usuario) {
        model.addAttribute("nome", usuario.getNome() + " " + usuario.getSobrenome());
        model.addAttribute("registerDate", usuario.getRegisterDate());
        model.addAttribute("username", usuario.getUsername());
        return model;
    }
}
