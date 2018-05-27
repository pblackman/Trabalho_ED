package Trabalho_2018;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class main_trabalho {

	public static void main(String[] args) {
		
        // Criando os tipos de assunto
       	tipoAssunto tipo_assunto1 = new tipoAssunto("internet","sem acesso a internet", 8); 
		tipoAssunto tipo_assunto2 = new tipoAssunto("pagamento","pagamento nao identificado", 10); 
		tipoAssunto tipo_assunto3 = new tipoAssunto("pagamento","emitir segunda via do boleto", 10); 
        tipoAssunto tipo_assunto4 = new tipoAssunto("internet","roteador com defeito", 7); 
        tipoAssunto tipo_assunto5 = new tipoAssunto("internet","internet lenta", 5);
		
        // Simulação dos atendimentos
        SimpleDateFormat horaChegadaCliente1 = new SimpleDateFormat("HH:mm:ss");
       	Cliente cliente1 = new Cliente("cpf1", "Ana", 52);
       	Assunto assunto1cliente1 = new Assunto(tipo_assunto1,"sem acesso a internet desde a semana passada");
        Assunto assunto2cliente1 = new Assunto(tipo_assunto2,"consta meu nome como devedor, mas já fiz o pagamento");
        ListaEstaticaDeAssuntos ListaEstaticaDeAssuntosCliente1 = new ListaEstaticaDeAssuntos();
        ListaEstaticaDeAssuntosCliente1.inserir(assunto1cliente1);
        ListaEstaticaDeAssuntosCliente1.inserir(assunto2cliente1);

        SimpleDateFormat horaChegadaCliente2 = new SimpleDateFormat("HH:mm:ss");
        Cliente cliente2 = new Cliente("cpf2", "Maria", 28);
        Assunto assunto3cliente2 = new Assunto(tipo_assunto4,"roteador com defeito");
        ListaEstaticaDeAssuntos ListaEstaticaDeAssuntosCliente2 = new ListaEstaticaDeAssuntos();
        ListaEstaticaDeAssuntosCliente2.inserir(assunto3cliente2);

        SimpleDateFormat horaChegadaCliente3 = new SimpleDateFormat("HH:mm:ss");
        Cliente cliente3 = new Cliente("cpf3", "Pedro", 80);
        Assunto assunto4cliente3 = new Assunto(tipo_assunto5,"internet lenta");
        ListaEstaticaDeAssuntos ListaEstaticaDeAssuntosCliente3 = new ListaEstaticaDeAssuntos();
        ListaEstaticaDeAssuntosCliente3.inserir(assunto4cliente3);

        Atendimento atendimento1 = new Atendimento();
        atendimento1.recepcionar(cliente1, ListaEstaticaDeAssuntosCliente1, horaChegadaCliente1 );
        
        Atendimento atendimento2 = new Atendimento();
        atendimento2.recepcionar(cliente2, ListaEstaticaDeAssuntosCliente2, horaChegadaCliente2 );
 
        Atendimento atendimento3 = new Atendimento();
        atendimento3.recepcionar(cliente3, ListaEstaticaDeAssuntosCliente3, horaChegadaCliente3 );
        
        MaxHeap maxHeapAtendimento = new MaxHeap(3);
        
        maxHeapAtendimento.insert(atendimento1.getPrioridadeCliente(), atendimento1);
        maxHeapAtendimento.insert(atendimento2.getPrioridadeCliente(), atendimento2);
        maxHeapAtendimento.insert(atendimento3.getPrioridadeCliente(), atendimento3);
        maxHeapAtendimento.maxHeap();
 
        maxHeapAtendimento.print();
        System.out.println("o proximo cliente a ser atendido é " + maxHeapAtendimento.remove());
	}
}


