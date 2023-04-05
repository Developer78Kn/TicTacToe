/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.util.Random;

/**
 *
 * @author Zsolt Ollé
 */
public class AI {
    private int num;
/*
- Kell a szorzó ez adja meg a táblá méretét
??? - Kell a level száma ez azért fontos hogy mikor kezdje el a gép ellenőrízni az ellefél lépéseit
- Kell a necessaryHit azaz a szűkséges találatok száma   
- Kell a necessaryHit azaz a szűkséges lépések száma az ellenőrzés elindításához
- ha a computer kezd akkor véletlen szerűen lép    
- figyelni hová lépett és azt követni
- ellenőrítni az ellefél lépését 2 vagy 3 egymás utánni jelet blokkolni
- előre gondolkodni hogy ki e jön a 3-4-5 egymás utánni jel és azt blokkolni.    
    
*/
    public AI() {
    }
    
    public int num(){
        System.out.println("Szorzó értéke: "+Level.getSzorzo());
        System.out.println("szükséges találat: "+WinWatcher.necessaryHit);
        System.out.println("szükséges lépések az ellenőrzés elindításához: "+WinWatcher.lepesKell);
        
        Random rnnum = new Random();
        num = rnnum.nextInt(Level.getSzorzo());
        return num;    
    }
}
