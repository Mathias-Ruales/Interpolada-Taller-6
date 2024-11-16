import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterpoladoGui {
    private JTextField textField1;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JTextArea txtResultado;
    private JPanel pGeneral;

    Lista lista=new Lista();

    public InterpoladoGui() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField1.getText();

                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, txtResultado);
                    textField1.setText("");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al ingresar el elemento");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField1.getText();

                try {
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor, txtResultado);
                    textField1.setText("");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al ingresar el elemento");
                }
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField1.getText();

                try {
                    int valor = Integer.parseInt(input);
                    int posicion=lista.buscarInterpolada(valor, txtResultado);

                    if (posicion==-1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
                    } else  {
                        JOptionPane.showMessageDialog(null, "El elemento: " + valor + " en la posicion: " + (posicion+1));
                    }

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al ingresar el elemento");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InterpoladoGui");
        frame.setContentPane(new InterpoladoGui().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
