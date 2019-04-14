package utn.Razas;

import utn.interfaces.IBeber;
import utn.interfaces.IOrinar;

import java.util.Objects;
import java.util.Random;

public class VikiTano extends Humano{

    private Integer bebedorProfesional = new Random().nextInt(5)+1;
    private Integer toleranciaExtra = new Random().nextInt(5)+1;

    public VikiTano() {
    }

    public VikiTano(String nombre, Integer edad, Integer peso) {
        super(nombre, edad, peso);
    }

    public VikiTano(String nombre, Integer edad, Integer peso, IOrinar orinar, IBeber beber) {
        super(nombre, edad, peso, orinar, beber);
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public void beberTurno(Integer bebido, double orina,Random random){
        if(random.nextBoolean()){
            bebido += this.bebedorProfesional;
            orina -= orina*0.1;
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
        VikiTano vikiTano = (VikiTano) o;
        return Objects.equals(bebedorProfesional, vikiTano.bebedorProfesional) &&
                Objects.equals(toleranciaExtra, vikiTano.toleranciaExtra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bebedorProfesional, toleranciaExtra);
    }

    @Override
    public String toString() {
        return "VikiTano{" + super.toString() +
                " BebedorProfesional = " + bebedorProfesional +
                ", ToleranciaExtra = " + toleranciaExtra +
                '}';
    }
}
