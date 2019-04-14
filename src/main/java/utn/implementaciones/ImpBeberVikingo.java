package utn.implementaciones;

import utn.interfaces.IBeber;

import java.util.Random;

public class ImpBeberVikingo implements IBeber {

    public ImpBeberVikingo() {
    }

    public Integer beber(){
        return new Random().nextInt(6)+1;
    }
}
