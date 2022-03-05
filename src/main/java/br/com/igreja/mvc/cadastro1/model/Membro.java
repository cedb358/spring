package br.com.igreja.mvc.cadastro1.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Membro {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nomeMembro;
	private LocalDate dataDoBatismo;
	private String urlImagem;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusMembro status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public StatusMembro getStatus() {
		return status;
	}
	public void setStatus(StatusMembro status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private String urlIgreja;
	private BigDecimal valorEntrada;
	
	
	
	public String getNome() {
		return nomeMembro;
	}
	public void setNome(String nome) {
		this.nomeMembro = nome;
	}
	public LocalDate getDataDoBatismo() {
		return dataDoBatismo;
	}
	public void setDataDoBatismo(LocalDate dataDoBatismo) {
		this.dataDoBatismo = dataDoBatismo;
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
	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public String getUrlIgreja() {
		return urlIgreja;
	}
	public void setUrlIgreja(String urlIgreja) {
		this.urlIgreja = urlIgreja;
	}
	public String getNomeMembro() {
		return nomeMembro;
	}
	public void setNomeMembro(String nomeMembro) {
		this.nomeMembro = nomeMembro;
	}

		
		
	}
	
		
	
	
		
	
	


