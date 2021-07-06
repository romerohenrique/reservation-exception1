package model.entinty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer NumApto;
    private Date entrada;
    private Date saida;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numApto, Date entrada, Date saida) {
        NumApto = numApto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumApto() {
        return NumApto;
    }

    public void setNumApto(Integer numApto) {
        NumApto = numApto;
    }

    public Date getEntrada() {
        return entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public long diarias() {
        long diff = saida.getTime() - entrada.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void remacarReserva(Date entrada, Date saida) {
        this.entrada = entrada;
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Apartamento= " + NumApto +
                ", entrada= " + sdf.format(entrada) +
                ", saida= " + sdf.format(saida) +
                ", duração= " + diarias() +
                ", noites" +
                '}';
    }
}
