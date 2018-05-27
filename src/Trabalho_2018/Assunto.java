package Trabalho_2018;

public class Assunto {
	
     private tipoAssunto tipo;
     private String descricao;
     private String providencias = null;
     private int duracaoAtendimento = 0;
     
     public Assunto(tipoAssunto tipo, String descricao){
    	 this.tipo = tipo;
    	 this.descricao = descricao;
     }

	public String getProvidencias() {
		return providencias;
	}

	public void setProvidencias(String providencias) {
		this.providencias = providencias;
	}

	public int getDuracaoAtendimento() {
		return duracaoAtendimento;
	}

	public void setDuracaoAtendimento(int duracaoAtendimento) {
		this.duracaoAtendimento = duracaoAtendimento;
	}
      
      
      
}
