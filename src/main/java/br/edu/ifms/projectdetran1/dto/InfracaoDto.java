package br.edu.ifms.projectdetran1.dto;

import br.edu.ifms.projectdetran1.model.Infracao;

public class InfracaoDto {
	private Long id;
	private String descricao;
	private int pontos;
	private float valor;
	
	public InfracaoDto() {
		// TODO Auto-generated constructor stub
	}

	public InfracaoDto(Infracao infracao) {
		super();
		this.id = infracao.getId();
		this.descricao = infracao.getDescricao();
		this.pontos = infracao.getPontos();
		this.valor = infracao.getValor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
