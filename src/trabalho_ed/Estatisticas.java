package trabalho_ed;
import java.text.SimpleDateFormat;
import java.util.Date;

import trabalho_ed.Estatistica.Metrica;

public class Estatisticas extends HashTable{

	public Estatisticas(int tamanho) {
		super(tamanho);
		// TODO Auto-generated constructor stub
	}
	
	public EstatisticaDia Buscar(Date data) {
		
		String strData = retornaStringData(data);
		return (EstatisticaDia)super.Buscar(strData);
				
	}
	
	public void IncluirEstatisticaDiaria(Date data) {
		
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
		System.out.println("Gerando Estatísticas ...");

		EstatisticaDia estatDia = this.Buscar(data);
		
		Estatistica est = estatDia.getEstatistica();
		for(int i = 0; i < est.lista.getTamanho(); i++) {
			Metrica m = (Metrica)est.lista.get(i);
			System.out.println("Assunto: " + m.getChave() + ", média:" + m.getMedia());
		}
		
	}
}
