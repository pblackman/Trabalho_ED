package Trabalho_2018;
import java.nio.ByteBuffer;

public class TipoAssunto extends ObjetoBase {

	private String tipo;
	private String titulo;
	private int urgencia;
	private int totalAtendimentos;
	private int totalMinutosAtendimento;
	
	public TipoAssunto(String tipo, String titulo, int urgencia)
	{
		this.tipo = tipo;
		this.titulo = titulo;
		this.urgencia = urgencia;
	}
	
    public Integer getHash() {
        String chave = this.tipo;
        ByteBuffer wrapped = ByteBuffer.wrap(chave.getBytes());
        return wrapped.getInt();
    }
    
    public String titulo() {
        return this.tipo;
    }
    
    public String getChave() {
        return this.tipo;
    }
    
    public TipoAssunto getConteudo() {
        return this;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
	public int getUrgencia() {
		return this.urgencia;
	}
	

	public int getTotalMinutosAtendimento() {
		return this.totalMinutosAtendimento;
	}
	
	public int getTotalAtendimentos() {
		return this.totalAtendimentos;
	}
}
