package trabalho_ed;
import java.text.SimpleDateFormat;
import java.util.Date;

import trabalho_ed.Estatistica.Metrica;

/* Classe Estatisticas herda de HashTable. � usada para armazenar uma  lista de
 * objetos EstatisticaDia (que representam um conjunto de estatisticasde um dia)

EXEMPLO DE ACESSO �S ESTATISTICAS EM O(1)
==================================
 * // Acesso em O(1) atrav�s da chave da data
	EstatisticaDia estatDia = Estatisticas.Buscar("20180624");
	// Acesso em O(1) a metrica atrav�s da chave do tipo de assunto
	Metrica metrica = estatDia.Estatistica.Buscar("TIPO1");

	//Acesso �s estat�sticas
	metrica.quantidade = 10; 
	metrica.tempoAtendimento  = 20;
	//calculo da m�dia
	float med = metrica.getMedia();
 * */



public class Estatisticas extends HashTable{

	public Estatisticas(int tamanho) {
		super(tamanho);
		// TODO Auto-generated constructor stub
	}
	
	public EstatisticaDia Buscar(Date data) {
		
		//Busca em O(1) a estatistica para o dia requerido
		
		String strData = retornaStringData(data);
		return (EstatisticaDia)this.Buscar(strData);
				
	}
	
	public void IncluirEstatisticaDiaria(Date data) {
		// Cria um novo objeto EstatisticaDia (hashtable de metricas)
		// e insere na hashtable de Estatisticas
		String strData = retornaStringData(data);
		EstatisticaDia estatDia = new EstatisticaDia(strData);
		this.Inserir(estatDia.getChave(), estatDia);
		
	}
	
	private String retornaStringData(Date data) {
		
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
	    String strDate = sdfDate.format(data);
	    return strDate;
	}
	
	public void GerarEstatistica(Date data) {
		
		System.out.println("");
		System.out.println("Gerando Estat�sticas ...");

		EstatisticaDia estatDia = this.Buscar(data);
		
		Estatistica est = estatDia.getEstatistica();
		
		//Acesso aos elementos mantidos no hashtable atraves da lista est�tica auxiliar
		//evitando assim varrer todo o hash table. Varre-se somente a lista estatica auxiliar
		for(int i = 0; i < est.lista.getTamanho(); i++) {
			Metrica m = (Metrica)est.lista.get(i);
			System.out.println("Assunto: " + m.getChave() + ", m�dia:" + m.getMedia());
		}
		
	}
}
