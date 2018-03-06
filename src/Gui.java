import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


/**
 * Created by plesha on 05-Mar-18.
 */
public class Gui extends Frame{
    private JFrame frame;
    private JButton afisareTren;
    private JLabel text;
    private JPanel mainPanel,panel2;
    private JTextField codTren;
    private JTextArea display;

    public Gui( Gara g1 ) {

        mainPanel = new JPanel(new GridBagLayout());

        frame  = new JFrame("Train Station");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);


        display = new JTextArea(12, 27);
        display.setLineWrap(false);
        display.setWrapStyleWord(true);
        display.setEditable(false);
        mainPanel.add(new JScrollPane(display));



        codTren = new JTextField();
        codTren.setBounds(90,10,250,30);
        frame.add(codTren);

        text = new JLabel("Cod Tren:");
        text.setBounds(20, 10, 300, 30);
        frame.add(text);


        afisareTren = new JButton("Afisare tren");
       // afisareTren.setBounds(50,10,50,30);

        mainPanel.add(afisareTren);


        // ---------------- ----------------  listener pe buton  ----------------  ----------------

        afisareTren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = codTren.getText();
                java.util.List<Tren> trenuri= new ArrayList<>();
                trenuri = g1.getTrenuri();
                 int ok =0;

                for( Tren t : trenuri){
                    if( t.getCod().equals(textFieldValue.toUpperCase()) ){
                        display.append(t.toString(t)+"\n");
                        ok = 1;
                    }
                }
                if(ok==0) {
                    display.append("Trenul cu codul " + textFieldValue + " nu a fost gasit!\n");
                }
            }
        });

        frame.setResizable(false);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

}
