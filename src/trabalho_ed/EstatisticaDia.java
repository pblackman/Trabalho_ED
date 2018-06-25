package trabalho_ed;

/*
 * Classe EstatisticaDia � uma classe associada a classe Estatistica.
 * Foi criada pois a classe Estatistica j� estende HashTable, e n�o poderia tamb�m
 * estender ObjetoBase para permitir o seu armazenamento tamb�m em uma HashTable.
 * */

public class EstatisticaDia extends ObjetoBase {
	
	private String data;
	private Estatistica estatistica;
	
	public EstatisticaDia(String data) {
		this.data = data;
		this.estatistica = new Estatistica(20);
	}
	
	public Estatistica getEstatistica() {
		
		return this.estatistica;

	}
	
	@Override
	public String getChave() {
		// TODO Auto-generated method stub
		return this.data;
	}

}
