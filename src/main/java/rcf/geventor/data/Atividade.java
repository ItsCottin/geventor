package rcf.geventor.data;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TBL_G_ATIVIDADE")
public class Atividade extends AbstractEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ID_ATIVI")
	private Long id;
	
	@Column(name="NOME_ATIVI")
	private String nome;
	
	@Column(name="DATAINICIO_ATIVI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio; 
	
	@Column(name="DATAFIM_ATIVI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;
	
	@Column(name="DETALHES_ATIVI")
	private String detalhes;
	
	@Column(name="ORGANIZACAO_ATIVI")
	private String organizacao;
	
	@Column(name="VAGAS_ATIVI")
	private int vagas;
	
	@Column(name="PRECO_ATIVI")
	private String preco;
	
	@Column(name="DT_ALTER_ATIVI")
	private Date dataAlter;
	
	@Column(name="IS_PERIODO_EVEN_ATIVI")
	private boolean usaPeriodoEven;
	
	@Transient
	private boolean doEditAtiv;
	
	@Transient
	private boolean foraPeriodoInicio;
	
	@Transient
	private boolean foraPeriodoFim;
	
	@Transient
	private boolean estaInscrito;
	
	@Transient
	private int qtdInscrito;
	
	@Transient
	private long qtdDifTemp;
	
	@Transient
    private String tpDifTemp;
	
	@Transient
	private boolean isgratuito;
	
	@Transient
	private boolean existeInscrito;
	
	@Transient
	private boolean eventonaovigente;
	
	@ManyToOne
	//@JoinColumn(name="ID_EVEN", referencedColumnName="ID_EVEN")
	public Evento evento;
	
	@OneToMany(mappedBy="atividade")
	private List<UsuarioAtividade> usuarioAtividade;
	
	public Atividade(){}
	
	public Atividade(Long id){
		this.id = id;
	}
}
