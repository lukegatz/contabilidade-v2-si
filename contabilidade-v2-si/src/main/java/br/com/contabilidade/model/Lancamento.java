package br.com.contabilidade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "lancamentoDB") //Define o nome da tabela que será criada no banco de dados
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_lancamento
	 * @param id_conta
	 * @param id_cliente
	 * @param id_bem
	 * @param valor
	 * @param data
	 * @param is_debito
	 * @param is_credito
	 */
	public Lancamento(Long id_lancamento, Long id_conta, Long id_cliente, Long id_bem, Double valor,
			Date data, boolean is_debito, boolean is_credito) {
		super();
		this.id_lancamento = id_lancamento;
		this.id_conta = id_conta;
		this.id_cliente = id_cliente;
		this.id_bem = id_bem;
		this.valor = valor;
		this.data = data;
		this.is_debito = is_debito;
		this.is_credito = is_credito;
	}

	@Id
	@SequenceGenerator(name = "lancamento_seq", sequenceName = "lancamento_seq") 		//Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lancamento_seq") 	//Define que a tabela fará uso da sequence criada antes
	private Long id_lancamento;
	
	@Column(nullable = false)
	private Long id_conta;
	
	@Column(nullable = false)
	private Long id_cliente;
	
	@Column(nullable = false)
	private Long id_bem;
	
	@Column
	private Double valor;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;
	
	@Column
	private boolean is_debito;
	
	@Column
	private boolean is_credito;
	
	// getters & setters
	public Long getId_lancamento() {
		return id_lancamento;
	}

	public void setId_lancamento(Long id_lancamento) {
		this.id_lancamento = id_lancamento;
	}

	public Long getId_conta() {
		return id_conta;
	}

	public void setId_conta(Long id_conta) {
		this.id_conta = id_conta;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getId_bem() {
		return id_bem;
	}

	public void setId_bem(Long id_bem) {
		this.id_bem = id_bem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isIs_debito() {
		return is_debito;
	}

	public void setIs_debito(boolean is_debito) {
		this.is_debito = is_debito;
	}

	public boolean isIs_credito() {
		return is_credito;
	}

	public void setIs_credito(boolean is_credito) {
		this.is_credito = is_credito;
	}
}
