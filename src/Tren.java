import  java.util.Comparator;

/**
 * Created by plesha on 05-Mar-18.
 */
public class Tren implements Comparable<Tren> {

    private String destinatie;
    private String ora;
    private String cod;

    Tren( String dest , String o , String c ) {
        destinatie = dest;
        ora = o;
        cod = c;
    }

    public String toString( Tren t ){
        return "Cod: "+ t.getCod() + " Destinatie: " + t.getDestinatie() + " Ora plecare " + t.getOra();
    }

    public String getDestinatie(){
        return destinatie;
    }
    public String getOra(){
        return ora;
    }
    public String getCod(){
        return cod;
    }

    public void setDestinatie( String d ){
        destinatie = d;
    }
    public void setOra( String o ){
        ora= o;
    }
    public void setCod( String c ){
        cod = c;
    }

    @Override
    public int compareTo(Tren t) {
        return Comparators.ORA.compare(this, t);
    }

    public static class Comparators{
        public static Comparator<Tren> ORA;
        static {
            ORA = new Comparator<Tren>() {
                @Override
                public int compare(Tren t1, Tren t2) {
                    String ora1 = t1.getOra();
                    String ora2 = t2.getOra();

                    String o1, m1, o2, m2;
                    o1 = m1 = o2 = m2 = null;

                    int h1 = 0, h2 = 0, min1 = 0, min2 = 0;

                    if (ora1.contains(":")) {
                        o1 = ora1.substring(0, ora1.indexOf(":"));
                        m1 = ora1.substring(ora1.indexOf(":") + 1);

                        h1 = Integer.parseInt(o1);
                        min1 = Integer.parseInt(m1);
                    }

                    if (ora2.indexOf(":") != -1) {
                        o2 = ora2.substring(0 , ora2.indexOf(":"));
                        m2 = ora2.substring(ora2.indexOf(":") + 1);

                        h2 = Integer.parseInt(o2);
                        min2 = Integer.parseInt(m2);
                    }
                    if( h1==h2 )
                        return min1-min2;
                    else
                        return h1 - h2;
                }
            };
        }


    }
}
