package Trabalho_2018;

import java.util.Random;

public class main_trabalho {

	
	public static void main(String[] args) {

		Random rand = new Random();
		
		Atendimentos Atendimentos = new Atendimentos(100);
		
		/*Simulando recepcionamento cliente 1*/
		Cliente cliente1 = new Cliente("cpf1", "Ana", 52);
		Atendimento atendimentoCliente1 = new Atendimento(cliente1);
		atendimentoCliente1.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO"), "Cobrança feita em duplicidade.");
		atendimentoCliente1.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("CANCELAMENTO"), "Cancelar todos os serviços.");
		Atendimentos.Recepcionar(atendimentoCliente1);
		
		/*Simulando recepcionamento cliente 2*/
		Cliente cliente2 = new Cliente("cpf2", "Joaquim", 85);
		Atendimento atendimentoCliente2 = new Atendimento(cliente2);
		atendimentoCliente2.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO"), "Solicita segunda via de boleto.");
		Atendimentos.Recepcionar(atendimentoCliente2);
	    
		/*Simulando recepcionamento cliente 3*/
		Cliente cliente3 = new Cliente("cpf3", "Paulo", 72);
		Atendimento atendimentoCliente3 = new Atendimento(cliente3);
		atendimentoCliente3.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO"), "Solicita segunda via de boleto.");
		atendimentoCliente3.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("VELOCIDADE"), "Internet muito lenta.");
	    Atendimentos.Recepcionar(atendimentoCliente3);
	    
	    /*pegando o próximo */
	    proximoAtendimento = Atendimentos.Atender();
	    
	    /***  Simulando Atendente varrendo lista de assuntos e resolvendo um a um ***/
	    for(int i =0; i< proximoAtendimento.getAssuntosTratados().getTamanho(); i++) {
	    	/*Busca Assunto a ser tratado*/
	    	Assunto a = (Assunto)proximoAtendimento.getAssuntosTratados().get(i);
	    	/*Random usado para definir um tempo aleatório de atendimento*/
	    	int randomTime = rand.nextInt((20 - 10) + 1) + 10; // ((Max - Min) + 1) - Min
	    	/* informa duração do atendimento para o assunto e providência tomada*/
	    	a.setDuracaoAtendimento(randomTime);
	    	a.setProvidencias("Providência_" + Integer.toString(randomTime) );
	    }
	    
	    /*Encerrando atendimento*/
	    Atendimentos.Encerrar(proximoAtendimento);
	    
	    /*pegando o próximo */
	    proximoAtendimento = Atendimentos.Atender();
	    
	    /***  Simulando Atendente varrendo lista de assuntos e resolvendo um a um ***/
	    for(int i =0; i< proximoAtendimento.getAssuntosTratados().getTamanho(); i++) {
	    	/*Busca Assunto a ser tratado*/
	    	Assunto a = (Assunto)proximoAtendimento.getAssuntosTratados().get(i);
	    	/*Random usado para definir um tempo aleatório de atendimento*/
	    	int randomTime = rand.nextInt((20 - 10) + 1) + 10; // ((Max - Min) + 1) - Min
	    	/* informa duração do atendimento para o assunto e providência tomada*/
	    	a.setDuracaoAtendimento(randomTime);
	    	a.setProvidencias("Providência_" + Integer.toString(randomTime) );
	    }
	    
	    /*Encerrando atendimento*/
	    Atendimentos.Encerrar(proximoAtendimento);
	    
	    /*pegando o próximo */
	    proximoAtendimento = Atendimentos.Atender();
	    
	    /***  Simulando Atendente varrendo lista de assuntos e resolvendo um a um ***/
	    for(int i =0; i< proximoAtendimento.getAssuntosTratados().getTamanho(); i++) {
	    	/*Busca Assunto a ser tratado*/
	    	Assunto a = (Assunto)proximoAtendimento.getAssuntosTratados().get(i);
	    	/*Random usado para definir um tempo aleatório de atendimento*/
	    	int randomTime = rand.nextInt((20 - 10) + 1) + 10; // ((Max - Min) + 1) - Min
	    	/* informa duração do atendimento para o assunto e providência tomada*/
	    	a.setDuracaoAtendimento(randomTime);
	    	a.setProvidencias("Providência_" + Integer.toString(randomTime) );
	    }
	    
	    /*Encerrando atendimento*/
	    Atendimentos.Encerrar(proximoAtendimento);

	    Atendimentos.GerarEstatisticas();
	    
	}
}


