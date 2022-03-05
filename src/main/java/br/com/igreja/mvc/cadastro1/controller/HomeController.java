package br.com.igreja.mvc.cadastro1.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igreja.mvc.cadastro1.model.Membro;
import br.com.igreja.mvc.cadastro1.model.StatusMembro;
import br.com.igreja.mvc.cadastro1.repository.MembroRepository;
import br.com.igreja.mvc.cadastro1.model.Membro;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private MembroRepository membrorepository;
	private JpaRepository<Membro, Long> repository;

	@GetMapping
	public String home(Model model, Principal principal) {

		List<Membro> membros = membrorepository.findAllByUsuario(principal.getName());
		model.addAttribute("membros", membros);

		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {

		List<Membro> membros = membrorepository.findByStatus(StatusMembro.valueOf(status.toUpperCase()));
		model.addAttribute("membros", membros);
		model.addAttribute("status", status);
		return "home";
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}

