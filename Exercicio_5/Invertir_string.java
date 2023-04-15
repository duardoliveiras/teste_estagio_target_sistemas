import java.util.Scanner;

public class Invertir_string {
    
    public static void main(String args[]){
        String texto;
        String texto_invertido = "";

        Scanner scan = new Scanner(System.in);

        texto = scan.nextLine();

        scan.close();

        for(int i = 0; i < texto.length(); i++){
            texto_invertido = texto_invertido + texto.charAt(texto.length() - i - 1);
        }

        System.out.println(texto_invertido);

    }

}
