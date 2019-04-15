package utn;

import utn.Razas.*;
import utn.implementaciones.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]){

        Conexion conexion = new Conexion(); // conexión a mysql
        Simulador simulador;

        List<Humano> vikingos = Arrays.asList(
                new Vikingo("Vikingo1", 25, 76, new ImpOrinarVikingo(), new ImpBeberVikingo()),
                new Vikingo("Vikingo2", 30, 80, new ImpOrinarVikingo(), new ImpBeberVikingo()),
                new Vikingo("Vikingo3", 28, 82, new ImpOrinarVikingo(), new ImpBeberVikingo()),
                new Vikingo("Vikingo4", 49, 95, new ImpOrinarVikingo(), new ImpBeberVikingo()),
                new Vikingo("Vikingo5", 37, 86, new ImpOrinarVikingo(), new ImpBeberVikingo())
        );

        List<Humano> espartanos = Arrays.asList(
                new Espartano("Espartano1",23,69, new ImpOrinarEspartano(), new ImpBeberEspartano()),
                new Espartano("Espartano2",38,82, new ImpOrinarEspartano(), new ImpBeberEspartano()),
                new Espartano("Espartano3",26,74, new ImpOrinarEspartano(), new ImpBeberEspartano()),
                new Espartano("Espartano4",40,79, new ImpOrinarEspartano(), new ImpBeberEspartano()),
                new Espartano("Espartano5",32,76, new ImpOrinarEspartano(), new ImpBeberEspartano())
        );

        // BOSS FINAL
        Humano tabernero = new VikiTano("tabernero1",54,102, new ImpOrinarEspartano(), new ImpBeberVikingo());

        // ORDENACIÓN
        vikingos = ordenarPorEdad(vikingos);
        espartanos = ordenarPorEdad(espartanos);

        // EQUIPOS ORDENADOS
        System.out.println("Equipo Vikingos:");
        listarEquipo(vikingos);
        System.out.println("\nEquipo Espartanos:");
        listarEquipo(espartanos);

        // ELEJIR ALEATOREAMENTE
        Vikingo v = (Vikingo) elejirParticipante(vikingos);
        Espartano e = (Espartano) elejirParticipante(espartanos);

        // PARTICIPANTES SELECCIONADOS
        System.out.println("\nParticipantes seleccionados:");
        System.out.println(v + "\n" + e);

        // ENFRENTAMIENTO
        simulador = new Simulador(v,e);
        Humano ganador = simulador.duelo();

        // RESULTADO ENFRENTAMIENTO
        System.out.println("\nEl ganador del duelo es: " + ganador.getNombre());
        System.out.println("\nRESULTADO FINAL: \n");
        mostrarResultado(v,e);

        // PERSISTENCIA GANADOR EN BD
        conexion.almacenarGanador(ganador);

        // EXTRA
        System.out.println("\nEl ganador se enfrenta al tabernero: ");
        System.out.println(ganador + "\n" + tabernero);

        ganador.restablecerEstadisticas();
        
        simulador = new Simulador(ganador,tabernero);
        Humano ganador2 = simulador.duelo();
        
        System.out.println("\nEl ganador del duelo es: " + ganador2.getNombre());
        System.out.println("\nRESULTADO vs BOSS: \n");
        mostrarResultado(ganador,tabernero);
    }

        public static List<Humano> ordenarPorEdad(List<Humano> equipo){
            return equipo.stream()
                    .sorted(Comparator.comparing(o -> o.getEdad()))
                    .collect(Collectors.toList());
        }

        public static void listarEquipo(List<Humano> equipo){
            equipo.stream().
                    forEach(o -> System.out.println(o));
        }

        public static Humano elejirParticipante(List<Humano> equipo){
            return equipo.get(new Random().nextInt(equipo.size()));
        }

        public static void mostrarResultado(Humano v, Humano e){
            System.out.println("Nombre:  " + v.getNombre() + "\n" +
                                "Tolerancia: " + v.getTolerancia() + "\n" +
                                "Orina Retenida: " + v.getOrinaRetenida() + "\n" +
                                "Total Bebido: " + v.getTotalBebido() + "\n");

            System.out.println("Nombre:  " + e.getNombre() + "\n" +
                                "Tolerancia: " + e.getTolerancia() + "\n" +
                                "Orina Retenida: " + e.getOrinaRetenida() + "\n" +
                                "Total Bebido: " + e.getTotalBebido());
        }

}
