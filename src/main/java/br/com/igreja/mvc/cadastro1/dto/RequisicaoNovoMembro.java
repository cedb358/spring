package br.com.igreja.mvc.cadastro1.dto;




import org.hibernate.validator.constraints.NotEmpty;

import br.com.igreja.mvc.cadastro1.model.Membro;
import br.com.igreja.mvc.cadastro1.model.StatusMembro;

public class RequisicaoNovoMembro {
	
	@NotEmpty
	private String nomeMembro;
	@NotEmpty
	private String urlMembro;
	@NotEmpty
	private String urlImagem;
	private String descricao;
	public String getNomeMembro() {
		return nomeMembro;
	}
	public void setNomeMembro(String nomeMembro) {
		this.nomeMembro = nomeMembro;
	}
	public String getUrlMembro() {
		return urlMembro;
	}
	public void setUrlMembro(String urlMembro) {
		this.urlMembro = urlMembro;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Membro toMembro() {
		Membro membro = new Membro();
		membro.setDescricao(descricao);
		membro.setNomeMembro(nomeMembro);
		membro.setUrlImagem(urlImagem);
		membro.setStatus(StatusMembro.AGUARDANDO);
		
		
		return membro;
	}

}
