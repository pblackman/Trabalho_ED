package trabalho_ed;

import java.util.Date;

public class Estatistica extends HashTable{
	ListaEstatica lista;
	
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
		
		//dataChegada ainda não é usada. Preciso criar uma coleção que guarde diferentes datas, para imprimir
		// as estatísticas somente do dia corrente
		
		System.out.println("Atualizando métricas: tipo '" + tipo + ", Duração Atendimento: " + tempoAtendimento);
		
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
