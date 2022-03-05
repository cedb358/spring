package br.com.igreja.mvc.cadastro1.repository;

import java.util.List;




import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.igreja.mvc.cadastro1.model.Membro;
import br.com.igreja.mvc.cadastro1.model.Membro;
import br.com.igreja.mvc.cadastro1.model.StatusMembro;


@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

	List<Membro> findByStatus(StatusMembro aguardando);

	Membro findById(long id);
	
	@org.springframework.data.jpa.repository.Query("select m from Membro m join m.user u where u.username = :username")
	List<Membro> findAllByUsuario(@Param("username")String username);
	
	
	
	

		
	}


