import java.util.ArrayList;
import java.util.List;
/**
 * Created by plesha on 05-Mar-18.
 */

public class Gara {
    List<Tren> trenuri= new ArrayList<>();

    Gara( List<Tren> trens ){
        trenuri = trens;
    }

    public List<Tren> getTrenuri() {
        return trenuri;
    }
}
