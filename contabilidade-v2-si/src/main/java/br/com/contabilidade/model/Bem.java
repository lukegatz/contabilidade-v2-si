package br.com.contabilidade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation")
//@Entity(name = "bemDB") //Define o nome da tabela que será criada no banco de dados
public class Bem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor. (BUILDER AQUI!!)
	 * 
	 * @param id_bem
	 * @param descricao
	 * @param id_tipo_bem
	 * @param valor
	 * @param documento
	 * @param data_cadastro
	 * @param chapa
	 */
	public Bem(Long id_bem, @NotBlank(message = "Autor é uma informação obrigatória.") String descricao,
			Long id_tipo_bem, Double valor,
			@NotBlank(message = "Documento é uma informação obrigatória.") String documento,
			@NotNull(message = "Data é uma informação obrigatória.") Date data_cadastro, String chapa) {
		super();
		this.id_bem = id_bem;
		this.descricao = descricao;
		this.id_tipo_bem = id_tipo_bem;
		this.valor = valor;
		this.documento = documento;
		this.data_cadastro = data_cadastro;
		this.chapa = chapa;
	}

	@Id	
	@SequenceGenerator(name = "bem_seq", sequenceName = "bem_seq") //Cria uma sequence para ser usada com a tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bem_seq") //Define que a tabela fará uso da sequence criada antes
	private Long id_bem;
	
	@Column(nullable = false, length = 150) //Define propriedades da coluna
	@NotBlank(message = "Autor é uma informação obrigatória.") //Define qual mensagem será exibida caso a validação da coluna falhar
	private String descricao;
	
	@Column(nullable = false)
	private Long id_tipo_bem;
	
	@Column
	private Double valor;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Documento é uma informação obrigatória.")
	private String documento;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data_cadastro;
	
	@Column
	private String chapa;

	public Long getId_bem() {
		return id_bem;
	}

	public void setId_bem(Long id_bem) {
		this.id_bem = id_bem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId_tipo_bem() {
		return id_tipo_bem;
	}

	public void setId_tipo_bem(Long id_tipo_bem) {
		this.id_tipo_bem = id_tipo_bem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
}
