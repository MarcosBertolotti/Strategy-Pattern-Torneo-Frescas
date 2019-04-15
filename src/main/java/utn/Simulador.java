package utn;

import utn.Razas.Humano;

import java.util.Random;

public class Simulador {

    public Humano p1;
    public Humano p2;

    public Simulador(Humano p1, Humano p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    /*
        el atributo orinaProducida y bebido comenzaran en 0.
        La tolerancia definira el tope de orina que se puede retener
        cada ves que se beba en un turno, se aumentan los atributos orina y bebido, luego se compara con la tolerancia.

        bebedorProfesional de Vikingo sumara mas puntos al atributo bebido y reduce el aumento de orinaProducida.
        toleranciaExtra de Espartano sumara puntos al atributo tolerancia.
     */
    public Humano duelo(){

        Random random = new Random();
        Integer bebido;
        double orina;
        Humano ganador;

        do {
            do {
                bebido = p1.getBeber().beber();
                orina = p1.getOrinar().orinar();
                p1.beberTurno(bebido, orina, random);

                bebido = p2.getBeber().beber();
                orina = p2.getOrinar().orinar();
                p2.beberTurno(bebido, orina, random);

            } while (p1.getOrinaRetenida() < p1.getTolerancia() && p2.getOrinaRetenida() < p2.getTolerancia());

            ganador = verificarGanador();
        }while(!Optional.ofNullable(ganador).isPresent());

        return ganador;
    }

    /*
        si la orina supera la tolerancia, el participante se orinara y perdera.
        El atributo bebido solo definira el ganador si los dos participantes se orinan en el mismo turno.
        Si se da el caso que los dos se orinan en el mismo turno y los dos beben la misma cantidad, se volvera a realizar el duelo.
    */
    public Humano verificarGanador(){

        Integer toleranciaP1 = p1.getTolerancia();
        double orinaP1 = p1.getOrinaRetenida();
        Integer bebidoP1 = p1.getTotalBebido();

        Integer toleranciaP2 = p2.getTolerancia();
        double orinaP2 = p2.getOrinaRetenida();
        Integer bebidoP2 = p2.getTotalBebido();

        if(orinaP1 < toleranciaP1 && orinaP2 > toleranciaP2)
            return p1;
        else if(orinaP1 > toleranciaP1 && orinaP2 < toleranciaP2)
            return p2;
        else{
            if(bebidoP1 > bebidoP2)
                return p1;
            else if(bebidoP1 < bebidoP2)
                return p2;
        }
        return null;
    }

}
