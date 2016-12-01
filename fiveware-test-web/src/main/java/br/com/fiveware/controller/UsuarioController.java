package br.com.fiveware.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveware.dao.UsuarioDAO;
import br.com.fiveware.dao.UsuarioEstadoCivilDAO;
import br.com.fiveware.model.Usuario;
import br.com.fiveware.model.UsuarioEstadoCivil;

@Controller
public class UsuarioController {

	@RequestMapping(value = "adicionarUsuario", method = RequestMethod.POST)
	public String adicionarUsuario(@RequestParam("nome") String nome, @RequestParam("telefone") String telefone,
			@RequestParam("dataNascimento") String dataNascimento, @RequestParam("sexo") char sexo,
			@RequestParam("usuarioEstadoCivil") int usuarioEstadoCivil) {
		UsuarioEstadoCivil estadoCivil = new UsuarioEstadoCivilDAO().getUsuariosEstadoCivil(usuarioEstadoCivil);
		String[] data = dataNascimento.split("-");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(data[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(data[1]));
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[1]));
		Usuario usuario = new Usuario(nome, calendar.getTime(), telefone, sexo, estadoCivil);
		new UsuarioDAO().inserir(usuario);
		return "usuarioAdicionado";
	}

	@RequestMapping("")
	public String form(Model model) {
		UsuarioEstadoCivilDAO usuarioEstadoCivilDAO = new UsuarioEstadoCivilDAO();
		model.addAttribute("estadoCivil", usuarioEstadoCivilDAO.getUsuariosEstadoCivils());
		return "cadastro";
	}
}
