package Trabalho_2018;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Atendimento {

	private Cliente cliente;
	private Assuntos assuntosTratados;
	private Date timestampChegada;
	private Date timestampAtendimento;
	private Date timestampEncerramento;
	private float prioridade;
	private int numAssuntos;
	
	public Atendimento(Cliente cliente) {
		this.assuntosTratados = new Assuntos(10);
		this.cliente = cliente;
	}
	
	public float getPrioridade() {
		Date timestamp = new Date();
		long espera = (timestamp.getTime() - this.timestampChegada.getTime())/(1000*60);
     	return (float) ((this.cliente.getIdade()/65.0 + espera/15.0 + assuntosTratados.getUrgenciaMedia()/10.0)/3.0);
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void IncluirAssunto(TipoAssunto tipo, String descricao){
	    Assunto assunto = new Assunto(tipo, descricao);
		this.assuntosTratados.Inserir(assunto);
	}

	public void setTimestampChegada() {
		this.timestampChegada = new Date();
	}
	
	public void setTimestampEncerramento() {
		this.timestampEncerramento = new Date();
	}
	
	public void setTimestampAtendimento() {
		this.timestampAtendimento = new Date();
	}
	
	public Date GerarEstatistica(){
		return null;
	
	}
}
