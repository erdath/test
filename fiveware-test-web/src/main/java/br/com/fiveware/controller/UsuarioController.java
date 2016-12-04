package br.com.fiveware.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiveware.dao.DAO;
import br.com.fiveware.model.Usuario;
import br.com.fiveware.model.UsuarioEstadoCivil;

@Controller
@Transactional
public class UsuarioController {
	
	@Qualifier("usuarioEstadoCivilDao")
	private DAO<UsuarioEstadoCivil> daoUsuarioEstadoCivil;
	private DAO<Usuario> daoUsuario;
	
	@Autowired
	public UsuarioController(DAO<UsuarioEstadoCivil> daoUsuarioEstadoCivil, DAO<Usuario> daoUsuario) {
		// TODO Auto-generated constructor stub
		this.daoUsuarioEstadoCivil = daoUsuarioEstadoCivil;
		this.daoUsuario = daoUsuario;
	}

	@RequestMapping(value = "adicionarUsuario", method = RequestMethod.POST)
	public String adicionarUsuario(@RequestParam("nome") String nome, @RequestParam("telefone") String telefone,
			@RequestParam("dataNascimento") String dataNascimento, @RequestParam("sexo") char sexo,
			@RequestParam("usuarioEstadoCivil") int usuarioEstadoCivil,Model model) {
		UsuarioEstadoCivil estadoCivil = daoUsuarioEstadoCivil.buscar(usuarioEstadoCivil);
		Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			model.addAttribute("error","Data invalida");
			e.printStackTrace();
		}
		Usuario usuario = new Usuario(nome, date, telefone, sexo, estadoCivil);
		daoUsuario.inserir(usuario);
		return "usuarioAdicionado";
	}
	
	@RequestMapping("")
	public String form(Model model) {
		//UsuarioEstadoCivilDAO usuarioEstadoCivilDAO = new UsuarioEstadoCivilDAO();
		//model.addAttribute("estadoCivil", usuarioEstadoCivilDAO.lista());
		model.addAttribute("estadoCivil",daoUsuarioEstadoCivil.lista());
		return "cadastro";
	}
}
