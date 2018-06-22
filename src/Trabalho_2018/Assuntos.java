package Trabalho_2018;

public class Assuntos extends ListaEstatica {
	private int sumUrgencias;
	public Assuntos(int tamanho) {
		super(tamanho);
		// TODO Auto-generated constructor stub
	}
	
    public boolean Inserir(Object e) {
        if (this.getTamanho() + 1 <= tamanho) {
        	Assunto ass = (Assunto)e;
        	this.sumUrgencias += ass.getTipoAssunto().getUrgencia();
            ((Object[]) this.lista)[indice++] = e;
            return true;
        }
        return false;
    }

    public int getUrgenciaMedia() {
    	return this.sumUrgencias/(indice + 1);
    }
}

