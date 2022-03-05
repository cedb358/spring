package br.com.igreja.mvc.cadastro1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igreja.mvc.cadastro1.model.User;
import br.com.igreja.mvc.cadastro1.dto.RequisicaoNovoMembro;
import br.com.igreja.mvc.cadastro1.model.Membro;
import br.com.igreja.mvc.cadastro1.model.StatusMembro;
import br.com.igreja.mvc.cadastro1.repository.MembroRepository;
import br.com.igreja.mvc.cadastro1.repository.UserRepository;


@Controller
@RequestMapping("membro")
public class MembroController {
	@Autowired
	private MembroRepository membroRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	crud insert , update , delete, lista consulta 
	
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoMembro requisicao) {
		return "membro/formulario";
		
	}
	
	
	
	@GetMapping("editar/{id}")
	public String porStatus(@PathVariable("id") long id, Model model) {

		Membro m = membroRepository.findById(id);
		model.addAttribute("membro", m);	
		return "membro/frmeditar";
	}
	
	@GetMapping("excluir/{id}")
	public String excluir(@PathVariable("id") long id, Model model) {

		Membro m = membroRepository.findById(id);
		membroRepository.delete(m);
		
		return "redirect:/home";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoMembro requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "membro/formulario";
			
			
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		
		Membro membro = requisicao.toMembro();
		User user =userRepository.findByUsername(username);
		
		membro.setUser(user);
		
		
		membroRepository.save(membro);
		
		return "redirect:/home";
		
	}

	@PostMapping("salvar")
	public String salvar(@Valid Membro membro, BindingResult result) {
		
		// Membro m = membroRepository.findById((long)membro.getId());	
		// m.setNome(membro.getNome());
		membroRepository.save(membro);
		
		return "redirect:/home";
		
	}
}

