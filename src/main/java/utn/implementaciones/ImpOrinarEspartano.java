package utn.implementaciones;

import utn.interfaces.IOrinar;

import java.util.Random;

public class ImpOrinarEspartano implements IOrinar {

    public ImpOrinarEspartano() {
    }

    public Integer orinar(){
        return new Random().nextInt(10)+1;
    }
}
