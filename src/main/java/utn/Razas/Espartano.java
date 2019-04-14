package utn.Razas;

import utn.interfaces.IBeber;
import utn.interfaces.IOrinar;

import java.util.Objects;
import java.util.Random;

public class Espartano extends Humano{

    private Integer toleranciaExtra = new Random().nextInt(5)+1;

    public Espartano() {
    }

    public Espartano(String nombre, Integer edad, Integer peso) {
        super(nombre, edad, peso);
    }

    public Espartano(String nombre, Integer edad, Integer peso, IOrinar orinar, IBeber beber) {
        super(nombre, edad, peso, orinar, beber);
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public void beberTurno(Integer bebido, double orina, Random random){
        if(random.nextBoolean()){
            this.setTolerancia(this.getTolerancia() + toleranciaExtra);
        }
        this.setTotalBebido(getTotalBebido() + bebido);
        this.setOrinaRetenida(getOrinaRetenida() + orina);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Espartano espartano = (Espartano) o;
        return Objects.equals(toleranciaExtra, espartano.toleranciaExtra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), toleranciaExtra);
    }

    @Override
    public String toString() {
        return "Espartano{" + super.toString() +
                " ToleranciaExtra = " + toleranciaExtra +
                '}';
    }
}
