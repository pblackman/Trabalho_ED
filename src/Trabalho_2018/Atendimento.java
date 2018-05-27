package Trabalho_2018;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class Atendimento {

	private Cliente cliente;
	private ListaEstaticaDeAssuntos listaAssuntos = null;
	private SimpleDateFormat horaChegada;
	private SimpleDateFormat horaAtendimento;
	
	private int i=0;
	private int tamanho;
	private int idade;
	private float tempoEspera;
	private float prioridadeCliente;
	private int urgencia;
	
	public void recepcionar(Cliente cliente, ListaEstaticaDeAssuntos ListaAssuntos, SimpleDateFormat horaChegada){
		this.cliente = cliente;
		this.listaAssuntos = ListaAssuntos;
		this.horaChegada = horaChegada;
	}
	
	public ListaEstaticaDeAssuntos atender(int idade, float tempoEspera, int urgencia){
		// o tempo de espera desta formula precisa ser refeito pegando a hora do sistema e diminuindo da hora de chegada
		// tem que implementar o metodo getAssuntoMaisUrgente na classe listaestaticadeassunto
		this.setPrioridadeCliente(((this.cliente.getIdade()/65)+(tempoEspera/15)+(this.listaAssuntos.getAssuntoMaisUrgente()/10))/3);
	    return this.listaAssuntos;
	
	}
	
	public void encerrar(){
		
	}
	
	public Date gerarEstatistica(){
		return null;
	
	}

	public float getPrioridadeCliente() {
		// o tempo de espera desta formula precisa ser refeito pegando a hora do sistema e diminuindo da hora de chegada
		// tem que implementar o metodo getAssuntoMaisUrgente na classe listaestaticadeassunto
		int assuntoMaisUrgente = 10; //this.listaAssuntos.getAssuntoMaisUrgente()
		this.prioridadeCliente = ((this.cliente.getIdade()/65)+(this.tempoEspera/15)+(assuntoMaisUrgente/10))/3;
		return prioridadeCliente;
	}

	public void setPrioridadeCliente(float prioridadeCliente) {
		this.prioridadeCliente = prioridadeCliente;
	}

	
}
