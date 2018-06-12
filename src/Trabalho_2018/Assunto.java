package trabalho_ed;

import java.nio.ByteBuffer;
import java.util.Date;

public class Assunto extends ObjetoBase {
	
     private TipoAssunto tipo;
     private String descricao;
     private String providencias = null;
     private int duracaoAtendimento = 0;
 	private long timestampAtendimentoAssunto;
 	private long timestampEncerramentoAssunto;
    
     public long getTimestampAtendimentoAssunto() {
    	//Date dt = new Date (timestampAtendimentoAssunto);
		return timestampAtendimentoAssunto;
	}

	public void setTimestampAtendimentoAssunto() {
		this.timestampAtendimentoAssunto = System.currentTimeMillis();//new Date();
	}

	public long getTimestampEncerramentoAssunto() {
		//Date dt = new Date (timestampEncerramentoAssunto);
		return timestampEncerramentoAssunto;
	}

	public void setTimestampEncerramentoAssunto() {
		this.timestampEncerramentoAssunto = System.currentTimeMillis();
	}

	public Assunto(TipoAssunto tipo, String descricao){
    	 this.tipo = tipo;
    	 this.descricao = descricao;
     }

     public TipoAssunto getTipoAssunto() {
    	 return this.tipo;
     }
	 public String getChave() {
	     return this.tipo.getChave();
	 }
	 
    public Object getConteudo() {  //Troquei para Objeto, porque estava dando erro
        return this;
    }
     
	public String getProvidencias() {
		return providencias;
	}
	
    public Integer getHash() {
        String chave = this.tipo.getChave();
        ByteBuffer wrapped = ByteBuffer.wrap(chave.getBytes());
        return null;//wrapped.getInt();  //retornei null, porque estava dando erro
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
