import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by plesha on 05-Mar-18.
 */
public class Test {
    public static void main(String[] arg){

        List<Tren> trenuri = new ArrayList<>() ;

        Tren t1 = new Tren("Berlin","10:01","AC1"),
             t2 = new Tren("Munchen","05:01","AC2"),
             t3 = new Tren("Frankfurt","16:01","AC3"),
             t4 = new Tren("Dusseldorf","10:31","AC4"),
             t5 = new Tren("Koln","13:01","AC5");

        trenuri.add(t1);
        trenuri.add(t2);
        trenuri.add(t3);
        trenuri.add(t4);
        trenuri.add(t5);

        Gara g1 = new Gara(trenuri);

        // -- inainte de sortare
        System.out.println("Inainte de sortare:------------------------------------------");
        for( Tren t : trenuri){
            System.out.println( t.toString(t) );
        }

       Collections.sort(trenuri,Tren.Comparators.ORA);

        // ---- dupa  sortare
        System.out.println("\n\nDupa sortare: -------------------------------------------------");
        for( Tren t : trenuri ){
            System.out.println( t.toString(t) );
        }

        // ------ GUI
        Gui g = new Gui(g1);

        return;
    }

}
