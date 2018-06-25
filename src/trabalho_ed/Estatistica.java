package trabalho_ed;

import java.util.Date;
/*
 * Classe Estatistica armazena objetos da classe Metrica
 * Uma Metrica cont�m um conjunto  de contatores para um tipo de assunto.
 * O acesso a uma m�trica de um tipo � feito em O(1)
 * */


public class Estatistica extends HashTable{
	//Lista est�tica auxiliar que guarda os objetos mantidos no hashtable
	// evitando que eu tenha que acessar elementos vazios quando quiser
	// imprimir as estat�sticas
	
	ListaEstatica lista;
	
	//Classe metrica guarda contadores para um tipo de assunto
	protected class Metrica extends ObjetoBase{
		private String Tipo;
		private int quantidade;
		private int tempoAtendimento;
		
		public Metrica(String tipo, int quantidade, int tempoAtendimento) {
			this.Tipo = tipo;
			this.quantidade = quantidade;
			this.tempoAtendimento = tempoAtendimento;
		}
		public float getMedia() {
			return this.tempoAtendimento/this.quantidade;
		}
		
	    public String getChave() {
	        return this.Tipo;
	    }
	}
		
	public Estatistica(int tamanho) {
		super(tamanho);
		
		lista = new ListaEstatica(tamanho);
		// TODO Auto-generated constructor stub
	}
	

	
	public void AtualizarMetrica(Date dataChegada, String tipo, int tempoAtendimento) {
		
		/*
		 * Busca em O(1) na hashtable, a m�trica para o tipo requerido.
		 * Se encontrar, atualiza os contadores.
		 * Caso contr�rio, cria um novo objeto Metrica e insere no hash
		 * */
		
		System.out.println("Atualizando m�tricas: tipo '" + tipo + ", Dura��o Atendimento: " + tempoAtendimento);
		
		Metrica metrica = (Metrica)this.Buscar(tipo);
		
		if(metrica == null) {
			Metrica m = new Metrica(tipo, 1, tempoAtendimento);
			this.Inserir(m.Tipo, m);
			lista.Inserir(m);
		}
		else {
			metrica.quantidade++;
			metrica.tempoAtendimento += tempoAtendimento;
		}
		
	}
}
