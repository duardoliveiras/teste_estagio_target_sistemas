package Faturamento_mensal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator; 




public class Main{


public static void main(String args[]) throws IOException{
    String caminho_json = "resources/dados.json"; // Caminho do arquivo .json
    
    StringBuilder jsonContent = new StringBuilder(); // usada para criar e manipular string 
    BufferedReader leitor; // usado para ler os dados do arqui .json
    
    try { // tente ler os dados do arquivo 
        leitor = new BufferedReader(new FileReader(caminho_json));      
        String linha;  // variavel para receber cada linha do conjunto json (cada linha possui um dia e um valor
        
        while( (linha = leitor.readLine()) != null){  // ler o arquivo enquanto tiver dados
            jsonContent.append(linha);   // empilha a linha no conteudoJson
        }
    } catch (FileNotFoundException e) { // se nao achar o arquivo execute a excessao de arquivo nao encontrado
        e.printStackTrace();
    }
    
    String json = jsonContent.toString(); // transforma os dados em uma string formal
    System.out.println(json);
    
    Gson gson = new Gson(); // Classe do google para para converter JSON em objetos java
    
    
    Type tipo = new TypeToken<ArrayList<Faturamento>>() {}.getType();  // armazena o tipo do ArrayList da classe faturamento
    
    ArrayList<Faturamento> fat = gson.fromJson(json, tipo); // utiliza o gson para instanciar objetos do tipo faturamento e armazenar no ArrayList
    
   double total_mes = 0;
   int dias_uteis = 0;
   
   Iterator<Faturamento> iterator = fat.iterator(); // iterator para percorrer o ArrayList
   
   double valor_max = 0;
   double valor_min = Double.POSITIVE_INFINITY; // armazena o maior valor possivel para o tipo Double
   
   while(iterator.hasNext()) {  // percorre o iterator equanto houver proximo 
	   
	   double valor = iterator.next().getValor(); // recebe o valor do objeto 
	   total_mes += valor; // variavel de somatoria do valor  
	   if(valor != 0) {  
		   dias_uteis += 1;
		   if(valor > valor_max) {
			   valor_max = valor;
		   }
		   if(valor < valor_min) {
			   valor_min = valor;
		   }
	   }
   }
 
   double faturamento_medio = (total_mes/dias_uteis); // media apenas dos dias uteis, ou seja, nos dias que houve algum valor de faturamento 
   
   System.out.printf("faturamento mensal: %.2f \ndias uteis: %d \nfaturamento medio: %.2f\nfaturamento minimo: %.2f\nfaturamento maximo: %.2f"
   ,total_mes, dias_uteis,faturamento_medio, valor_min, valor_max);




}

public static class Faturamento{
	private int dia;
	private double valor;
	
	public int getDia() {
		return this.dia;
	}
	public double getValor() {
		return this.valor;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "Dia: "+ this.dia + " Valor: " + this.valor;
	}
}


}