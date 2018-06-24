package trabalho_ed;

import java.text.SimpleDateFormat;
import java.util.Date;

import trabalho_ed.MaxHeap.HeapItem;

/* A classe Atendimentos representa a fila de Atendimentos enfileirados por prioridade.
 * Herda de MaxHeap, mas tem uma implementação específica do método remover, que solicita reorganização do heap antes da remoção de um item.
 * Esta reorganização é necessária p/ que eventuais mudanças de prioridade em função do tempo possam ser contabilizadas.
 * */


public class Atendimentos extends MaxHeap {
	TiposAssuntos tiposAssuntos;
	Estatisticas estatisticas;
	
	public Atendimentos(int maxsize, Estatisticas estatisticas) {
		super(maxsize);
		this.estatisticas = estatisticas;
		this.tiposAssuntos = new TiposAssuntos(System.getProperty("user.dir") + "\\data\\TipoAssunto.txt");
		// TODO Auto-generated constructor stub
	}
	
	public TiposAssuntos getTiposAssuntos() {
		return this.tiposAssuntos;
	}

	public void Recepcionar(Atendimento atendimento)  {
		atendimento.setTimestampChegada();
		System.out.println("Cliente tem prioridade " + atendimento.getPrioridade());
		
		try {
			this.inserir(atendimento.getPrioridade(), atendimento);	
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Atendimento Atender() {
		Atendimento atendimento = (Atendimento)this.remover().getItem();
		atendimento.setTimestampAtendimento();
		System.out.println("Próximo cliente-> Nome: " + atendimento.getCliente().getNome() + ", idade: "  + atendimento.getCliente().getIdade());
		return atendimento;
	}
	
	public void Encerrar(Atendimento atendimento) {
		System.out.println("");
		System.out.println("Encerrando atendimento para cliente nome:'" + atendimento.getCliente().getNome() +  
				"', idade: " + atendimento.getCliente().getIdade() + ", prioridade: " + atendimento.getPrioridade());
	    
		//Busca o objeto Estatística do dia
		EstatisticaDia estatDia = this.estatisticas.Buscar(atendimento.getTimestampChegada());
		
		for(int i = 0; i< atendimento.getAssuntosTratados().getTamanho(); i++) {
	    	Assunto a = (Assunto)atendimento.getAssuntosTratados().get(i);
	    	System.out.println("Descrição Assunto " + i + ": " + a.getDescricao() + ", Providência:" + a.getProvidencias());
	    	
	    	//atualiza as estatísticas
	    	estatDia.getEstatistica().AtualizarMetrica(atendimento.getTimestampChegada(), a.getChave(), a.getDuracaoAtendimento());
	    }
	    System.out.println("");

	    //Define timestamp de encerramento
	    atendimento.setTimestampEncerramento();
	}
	
	//Função de remoção do heap que solicita rearranjo antes
	public HeapItem remover() {
		super.arranjar();
		return super.remover();
	}

}
