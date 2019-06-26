package br.com.contabilidade.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
@Entity(name = "telefoneDB") //Define o nome da tabela que será criada no banco de dados
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Telefone() {}
	
	/**
	 * Construtor.
	 * 
	 * @param id_fone
	 * @param id_cliente
	 * @param tipo
	 * @param numero
	 */
	public Telefone(Long id_fone, Long id_cliente, String tipo,
			Integer numero) {
		super();
		this.id_fone = id_fone;
		this.id_cliente = id_cliente;
		this.tipo = tipo;
		this.numero = numero;
	}

	@Id	
	@SequenceGenerator(name = "telefone_seq", sequenceName = "telefone_seq") 			//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_seq") 	//Define que a tabela fará uso da sequence criada antes
	private Long id_fone;
	
	@Column(nullable = false)
	private Long id_cliente;
	
	@Column
	private String tipo;
	
	@Column(nullable = false)
	@NotBlank(message = "Telefone é uma informação obrigatória.")
	private Integer numero;
	
	// getters & setters
	public Long getId_fone() {
		return id_fone;
	}

	public void setId_fone(Long id_fone) {
		this.id_fone = id_fone;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
