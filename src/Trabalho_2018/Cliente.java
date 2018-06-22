package Trabalho_2018;

public class Cliente {
	private String cpf;
	private String nome;
	private int idade;
	
	public Cliente(String cpf, String nome, int idade){
		this.cpf = cpf;
		this.nome=nome;
		this.setIdade(idade);
		System.out.println("Novo cliente - nome:'" + this.nome + "', cpf:'" + this.cpf + "', idade:" + this.idade);
	}
	

	public String getCpf(){
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
