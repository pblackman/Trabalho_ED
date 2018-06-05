package Trabalho_2018;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TiposAssuntos extends HashTable {
	public TiposAssuntos(int tamanho) {
		super(tamanho);
		// TODO Auto-generated constructor stub
	}
	
	public TiposAssuntos(String filePath) {
		super(100);
		try { 
			LoadListFromFile(filePath);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void LoadListFromFile(String filePath) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(filePath));
	try {
	    String line = br.readLine();

	    while (line != null) {
	    	String[] data = line.split(";");
	    	TipoAssunto tpAssunto = new TipoAssunto(data[0].trim(),data[1].trim(), Integer.parseInt(data[2].trim()));
	    	this.Inserir(tpAssunto.getChave(), tpAssunto);
	        line = br.readLine();
	    }
	} 
	finally {
	    br.close();
	}
	}
}
