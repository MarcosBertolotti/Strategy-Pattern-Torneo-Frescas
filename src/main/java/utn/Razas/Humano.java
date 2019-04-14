package utn.Razas;

import utn.interfaces.IBeber;
import utn.interfaces.IOrinar;

import java.util.Objects;
import java.util.Random;

public abstract class Humano {

    private String nombre;
    private Integer edad;
    private Integer peso;
    private IOrinar orinar;
    private IBeber beber;
    private Integer tolerancia;
    private Integer totalBebido;
    private double orinaRetenida;

    public Humano(){
        this.tolerancia = new Random().nextInt(20)+90;
        this.totalBebido = 0;
        this.orinaRetenida = 0;
    }

    public Humano(String nombre, Integer edad, Integer peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.tolerancia = new Random().nextInt(20)+90;
        this.totalBebido = 0;
        this.orinaRetenida = 0;
    }

    public Humano(String nombre, Integer edad, Integer peso, IOrinar orinar, IBeber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
        this.tolerancia = new Random().nextInt(20)+90;
        this.totalBebido = 0;
        this.orinaRetenida = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public IOrinar getOrinar() {
        return orinar;
    }

    public void setOrinar(IOrinar orinar) {
        this.orinar = orinar;
    }

    public IBeber getBeber() {
        return beber;
    }

    public void setBeber(IBeber beber) {
        this.beber = beber;
    }

    public Integer getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(Integer tolerancia) {
        this.tolerancia = tolerancia;
    }

    public Integer getTotalBebido() {
        return totalBebido;
    }

    public void setTotalBebido(Integer totalBebido) {
        this.totalBebido = totalBebido;
    }

    public double getOrinaRetenida() {
        return orinaRetenida;
    }

    public void setOrinaRetenida(double orinaRetenida) {
        this.orinaRetenida = orinaRetenida;
    }

    public abstract void beberTurno(Integer bebido, double orina,Random random);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Humano humano = (Humano) o;
        return Objects.equals(nombre, humano.nombre) &&
                Objects.equals(edad, humano.edad) &&
                Objects.equals(peso, humano.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, peso);
    }

    @Override
    public String toString() {
        return  nombre +
                ", Edad = " + edad +
                ", Peso = " + peso +
                ", Tolerancia = " + tolerancia;
    }
}
