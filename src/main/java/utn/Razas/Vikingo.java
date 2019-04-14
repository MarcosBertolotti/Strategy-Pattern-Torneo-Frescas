package utn.Razas;

import utn.interfaces.IBeber;
import utn.interfaces.IOrinar;

import java.util.Objects;
import java.util.Random;

public class Vikingo extends Humano{

    private Integer bebedorProfesional = new Random().nextInt(5)+1;

    public Vikingo() {
    }

    public Vikingo(String nombre, Integer edad, Integer peso) {
        super(nombre, edad, peso);
    }

    public Vikingo(String nombre, Integer edad, Integer peso, IOrinar orinar, IBeber beber) {
        super(nombre, edad, peso, orinar, beber);
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    @Override
    public void beberTurno(Integer bebido, double orina, Random random){
        if(random.nextBoolean()){
            bebido += this.bebedorProfesional;
            orina -= orina*0.1;
        }
        this.setTotalBebido(getTotalBebido() + bebido);
        this.setOrinaRetenida(getOrinaRetenida() + orina);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vikingo vikingo = (Vikingo) o;
        return Objects.equals(bebedorProfesional, vikingo.bebedorProfesional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bebedorProfesional);
    }

    @Override
    public String toString() {
        return "Vikingo{" + super.toString() +
                " BebedorProfesional = " + bebedorProfesional +
                "}";
    }
}
