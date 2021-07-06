package aplication;

import model.entinty.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Número do quarto");
        int num = sc.nextInt();
        System.out.println("Data de entrada: dd/mm/aaaa");
        Date entrada = sdf.parse(sc.next());
        System.out.println("Darta de saída: dd/mm/aaaa");
        Date saida = sdf.parse(sc.next());
        if (!saida.after(entrada)) {
            System.out.println("Erro na reserva: A data de saída precisa ser após a data de entrada.");
        } else {
            Reserva reserva = new Reserva(num, entrada, saida);
            System.out.println("Reserva: " + reserva.toString());
            System.out.println("-----//-----");

            System.out.println("Remarcar Reserva");
            System.out.println("Data de entrada: dd/mm/aaaa");
            entrada = sdf.parse(sc.next());
            System.out.println("Darta de saída: dd/mm/aaaa");
            saida = sdf.parse(sc.next());

            Date atual = new Date();

            if (entrada.before(atual) || saida.before(atual)){
                System.out.println("Erro na reserva: as datas para remarcar deverá ser futuras");
            }
            else if(!saida.after(entrada)) {
                System.out.println("Erro na reserva: A data de saída precisa ser após a data de entrada.");
            }else {
                reserva.remacarReserva(entrada, saida);
                System.out.println("Reserva: " + reserva.toString());
            }

        }

        sc.close();
    }
}
