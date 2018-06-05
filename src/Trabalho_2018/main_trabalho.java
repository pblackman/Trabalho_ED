package Trabalho_2018;

public class main_trabalho {

	
	public static void main(String[] args) {

		Atendimentos Atendimentos = new Atendimentos(100);
		
		Cliente cliente1 = new Cliente("cpf1", "Ana", 52);
		Atendimento atendimentoCliente1 = new Atendimento(cliente1);
		TipoAssunto tp1 = (TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO");
		atendimentoCliente1.IncluirAssunto(tp1, "Cobrança feita em duplicidade.");
		atendimentoCliente1.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("CANCELAMENTO"), "Cancelar todos os serviços.");
		
		
		Cliente cliente2 = new Cliente("cpf2", "Joaquim", 85);
		Atendimento atendimentoCliente2 = new Atendimento(cliente2);
		atendimentoCliente2.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO"), "Solicita segunda via de boleto.");

	    
		Cliente cliente3 = new Cliente("cpf3", "Paulo", 72);
		Atendimento atendimentoCliente3 = new Atendimento(cliente3);
		atendimentoCliente3.IncluirAssunto((TipoAssunto)Atendimentos.getTiposAssuntos().Buscar("BOLETO"), "Solicita segunda via de boleto.");
	    Atendimentos.Recepcionar(atendimentoCliente1);
	    Atendimentos.Recepcionar(atendimentoCliente2);
	    Atendimentos.Recepcionar(atendimentoCliente3);
	    
	    Atendimento proximoAtendimento = Atendimentos.Atender();
	    Atendimento proximoAtendimento2 = Atendimentos.Atender();
	    Atendimento proximoAtendimento3 = Atendimentos.Atender();
	    
	    
	}
}


