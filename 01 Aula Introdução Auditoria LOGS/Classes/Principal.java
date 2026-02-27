import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Principal 
{
	//Total de falhas permitidas
	int TOTAL_FALHAS = 3;
	
	//Caminho do arquivo de log
	static String CAMINHO_LOG = "auth.log";
	
	static String CAMINHO_ALERTA = "alerta.log";
	
	public static void main(String[] args) 
	{		
		//'local' para armazenar os valores
		HashMap<String, Integer> falhas = 
				new HashMap<>();
		
		try( 
		 BufferedReader br = new 
		      BufferedReader(new FileReader(CAMINHO_LOG));
		 BufferedWriter bw = new 
				  BufferedWriter(new FileWriter(CAMINHO_ALERTA));)
		{
			//Percorrer linha a linha do file
			String linha;
			while((linha = br.readLine()) != null ) 
			{
				//Verificar se existe ERROR
				if(linha.contains("ERROR"))
				{
					//Acha o primeiro '
					int inicio = linha.indexOf("'");
					
					//Acha o último '
					int fim  = linha.indexOf("'");
					
					//Extrai o nome do user
					String usuario = linha.substring(inicio,fim);
					
					//Atualizando o contador de erros
					falhas.put(usuario, falhas.getOrDefault(usuario, 0)+1);
					
				}
				
			}
			
			
			
		}
		catch (IOException e) 
		{
			
		}
	};
}


