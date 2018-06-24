package trabalho_ed;

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
