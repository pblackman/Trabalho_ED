package Trabalho_2018;

public class ListaEstaticaDeAssuntos {
	
	private Assunto[] lista = new Assunto[100];
    int contador = 0;

    public boolean inserir(Assunto assunto) {
        if (contador < lista.length) {
            lista[contador++] = assunto;
            return true;
        } else
            return false;
   }
    
 	public int getAssuntoMaisUrgente() {
        //fazer a leitura de todos os assuntos da lista e trazer o assunto mais urgente do cliente
 		// por enquanto estou retornando sempre o numero 10
		return 10;
	}


}
