import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtTexto;
    private JButton btnApilar;
    private JButton btnDesapilar;
    private JTextArea txtMostrar;
    private JLabel lblEtiqueta;
    private JButton btnPeek;
    private JTextField txtPeekTextField;
    private Pila lista=new Pila();

    public Ventana() {
        btnApilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               lista.apilar(txtTexto.getText());
               txtMostrar.setText(lista.toString());
            }
        });
        btnDesapilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String eliminado = lista.desapilar();
                    JOptionPane.showMessageDialog(null,"Eliminado: "+eliminado);
                    txtMostrar.setText(lista.toString());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        btnPeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cima = lista.cima();
                    JOptionPane.showMessageDialog(null,cima);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"No existe un elemento");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
