package trabalho_ed;

import javax.naming.LimitExceededException;

public class Atendimentos extends MaxHeap {
	TiposAssuntos tiposAssuntos;
	Estatisticas estatisticas = new Estatisticas(20);
	
	public Atendimentos(int maxsize) {
		super(maxsize);
		tiposAssuntos = new TiposAssuntos(System.getProperty("user.dir") + "\\data\\TipoAssunto.txt");
		// TODO Auto-generated constructor stub
	}
	
	public TiposAssuntos getTiposAssuntos() {
		return this.tiposAssuntos;
	}

	public void Recepcionar(Atendimento atendimento)  {
		atendimento.setTimestampChegada();
		System.out.println("Cliente tem prioridade " + atendimento.getPrioridade());
		
		try {
			this.insert(atendimento.getPrioridade(), atendimento);	
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
	    for(int i = 0; i< atendimento.getAssuntosTratados().getTamanho(); i++) {
	    	Assunto a = (Assunto)atendimento.getAssuntosTratados().get(i);
	    	System.out.println("Descrição Assunto " + i + ": " + a.getDescricao() + ", Providência:" + a.getProvidencias());
	    	estatisticas.AtualizarMetrica(atendimento.getTimestampChegada(), a.getChave(), a.getDuracaoAtendimento());
	    }
	    System.out.println("");
	    //Define timestamp de encerramento
	    
	    atendimento.setTimestampEncerramento();
	}
	
	public void GerarEstatisticas() {
		estatisticas.GerarEstatisticas();
	}
	
	private String retornaStringData(Date data) {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
	    String strDate = sdfDate.format(data);
	    return strDate;
}

}
