package aplication;

import model.entinty.Reserva;
import model.entinty.model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Número do quarto");
            int num = sc.nextInt();
            System.out.println("Data de entrada: dd/mm/aaaa");
            Date entrada = sdf.parse(sc.next());
            System.out.println("Darta de saída: dd/mm/aaaa");
            Date saida = sdf.parse(sc.next());

            Reserva reserva = new Reserva(num, entrada, saida);
            System.out.println("Reserva: " + reserva.toString());

            System.out.println("-----//-----");
            System.out.println("Remarcar Reserva");
            System.out.println("Data de entrada: dd/mm/aaaa");
            entrada = sdf.parse(sc.next());
            System.out.println("Darta de saída: dd/mm/aaaa");
            saida = sdf.parse(sc.next());

            reserva.remacarReserva(entrada, saida);
            System.out.println("Reserva: " + reserva.toString());
        } catch (ParseException e) {
            System.out.println("formato de data inválido");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado");
        }
        sc.close();
    }
}
