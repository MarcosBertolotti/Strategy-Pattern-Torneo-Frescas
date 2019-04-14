package utn.implementaciones;

import utn.interfaces.IBeber;

import java.util.Random;

public class ImpBeberEspartano implements IBeber {


    public ImpBeberEspartano() {
    }

    public Integer beber(){
        return new Random().nextInt(5)+1;
    }

    



}
