package com.cloud.backend.dto;

import com.cloud.backend.domain.Iac;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IacDTO implements java.io.Serializable{


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Double preco;
	private String inscricao;
	private String saccional;
	private String agenda;
	private String email;
	private String cpfOuCnpj;
	@JsonIgnore
	private String senha;
	
	public IacDTO() {
	}
	public IacDTO(Iac iac) {
		id = iac.getId();
		name = iac.getName();
		preco = iac.getPreco();
		inscricao = iac.getInscricao();
		saccional = iac.getSaccional();
		email = iac.getEmail();
		cpfOuCnpj = iac.getCpfOuCnpj();
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getInscricao() {
		return inscricao;
	}
	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}
	public String getSaccional() {
		return saccional;
	}
	public void setSaccional(String saccional) {
		this.saccional = saccional;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
