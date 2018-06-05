package Trabalho_2018;

public class Atendimentos extends MaxHeap {
	TiposAssuntos tiposAssuntos;
	public Atendimentos(int maxsize) {
		super(maxsize);
		tiposAssuntos = new TiposAssuntos(System.getProperty("user.dir") + "\\data\\TipoAssunto.txt");
		// TODO Auto-generated constructor stub
	}
	
	public TiposAssuntos getTiposAssuntos() {
		return this.tiposAssuntos;
	}

	public void Recepcionar(Atendimento atendimento) {
		atendimento.setTimestampChegada();
		System.out.println(atendimento.getPrioridade());
		this.insert(atendimento.getPrioridade(), atendimento);
	}
	
	public Atendimento Atender() {
		Atendimento atendimento = (Atendimento)this.remove().getItem();
		atendimento.setTimestampAtendimento();
		System.out.println("Próximo cliente-> Nome: " + atendimento.getCliente().getNome() + ", idade: "  + atendimento.getCliente().getIdade());
		return atendimento;
		
	}
	
	public void GerarEstatisticas() {
		
		
	}

}
