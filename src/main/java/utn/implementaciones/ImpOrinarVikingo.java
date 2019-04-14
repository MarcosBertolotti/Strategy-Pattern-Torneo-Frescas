package utn.implementaciones;

import utn.interfaces.IOrinar;

import java.util.Random;

public class ImpOrinarVikingo implements IOrinar {

    public ImpOrinarVikingo() {
    }

    public Integer orinar(){
        return new Random().nextInt(7)+1;
    }
}
