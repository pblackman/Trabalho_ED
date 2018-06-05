package Trabalho_2018;

import java.nio.ByteBuffer;

public class Assunto extends ObjetoBase {
	
     private TipoAssunto tipo;
     private String descricao;
     private String providencias = null;
     private int duracaoAtendimento = 0;
     
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
	 
    public Assunto getConteudo() {
        return this;
    }
     
	public String getProvidencias() {
		return providencias;
	}
	
    public Integer getHash() {
        String chave = this.tipo.getChave();
        ByteBuffer wrapped = ByteBuffer.wrap(chave.getBytes());
        return wrapped.getInt();
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
