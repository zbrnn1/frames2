package br.edu.ifms.projectdetran1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Carro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String nome;
	private String placa;
	private String marca;
	private int modelo;
	private String cor;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "carro")
	private Apolice apolice;
	
	@OneToMany(mappedBy = "carro")
	private List<Multa> multas = new ArrayList<Multa>();
	
	
	public Carro() {
		
	}


	public Carro(Long id, String nome, String placa, String marca, int modelo, String cor, Apolice apolice) {
		super();
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.apolice = apolice;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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
	

	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}


	

	public List<Multa> getMultas() {
		return multas;
	}



	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	


	public Apolice getApolice() {
		return apolice;
	}


	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
