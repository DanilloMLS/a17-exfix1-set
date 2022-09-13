package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entities.Log;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Entre com o caminho completo do arquivo:");
        String arquivo = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            Set<Log> lista = new TreeSet<>();
            String linha = br.readLine();
            
            while (linha != null) {
            
                String[] dado = linha.split(" ");
                Date data = Date.from(Instant.parse(dado[1]));
                lista.add(new Log(dado[0], data));
                linha = br.readLine();

            }

            for (Log log : lista) {
                System.out.println(log);
            }

            System.out.println(lista.size());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
