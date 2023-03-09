package br.edu.ifms.detran.dto;

import br.edu.ifms.detran.model.Carro;

public class CarroDto {
	
	private Long id; 
	private String nome;
	private String marca;
	private int modelo;
	private String placa;
	private String cor;
	
	
	public CarroDto() {
		
	}


	public CarroDto(Carro carro) {
		super();
		this.id = carro.getId();
		this.nome = carro.getNome();
		this.marca = carro.getMarca();
		this.modelo = carro.getModelo();
		this.placa = carro.getPlaca();
		this.cor = carro.getCor();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getModelo() {
		return modelo;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	

}
