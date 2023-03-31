package br.edu.ifms.detran.dto;

import br.edu.ifms.detran.model.Infracao;

public class InfracaoDto {
	
	private Integer id;
	private String descricao;
	private int pontos;
	private float valor;
	
	
	public InfracaoDto() {
		
	}


	public InfracaoDto(Infracao infracao) {
		super();
		this.id = infracao.getId();
		this.descricao = infracao.getDescricao();
		this.pontos = infracao.getPontos();
		this.valor = infracao.getValor();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getPontos() {
		return pontos;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
	

}
