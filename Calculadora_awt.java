package calculadora_awt;
import java.awt.*;
import java.awt.event.*;

public class Calculadora_awt extends Frame implements ActionListener{
int numeroUno = 0; 
int numeroDos = 0; 
int resultado = 0;
char operador;
TextField pantalla_inicial;
Panel panel;
 
String botones[] = {"7", "8", "9", "Borrar", "4", "5", "6", "+", "1", "2", "3", "-", "*", "0", "/", "="};
Button btn[] = new Button[20];   

 
    public Calculadora_awt() {
        pantalla_inicial = new TextField(10);
        panel = new Panel();
        add(pantalla_inicial, "North");
        add(panel, "Center");
        panel.setLayout(new GridLayout(4,4));

        for(int i=0; i < botones.length; i++) {
            btn[i] = new Button(botones[i]); 
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
  
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent we) {
            System.exit(0);
           }
          });
    }
public void actionPerformed(ActionEvent ae) {
  
String op = ae.getActionCommand();
  
    if(op.equals("+")) {
        operador = '+';
        numeroUno = Integer.parseInt(pantalla_inicial.getText());
        pantalla_inicial.setText("");
    }
    else if(op.equals("-")) {
        operador = '-';
        numeroUno = Integer.parseInt(pantalla_inicial.getText());
        pantalla_inicial.setText("");
    }
    else if(op.equals("*")) {
        operador = '*';
        numeroUno = Integer.parseInt(pantalla_inicial.getText());
        pantalla_inicial.setText("");
      }
    else if(op.equals("/")) {
        operador = '/';
        numeroUno = Integer.parseInt(pantalla_inicial.getText());
        pantalla_inicial.setText("");
    }
    else if(op.equals("=")) {  
    numeroDos = Integer.parseInt(pantalla_inicial.getText());
   
        switch(operador) {
            case '+' : resultado = numeroUno + numeroDos;
             break;
            case '-' : resultado = numeroUno - numeroDos;
             break;
            case '*' : resultado = numeroUno * numeroDos;
             break;
            case '/' : resultado = numeroUno / numeroDos;
             break;
        }
    pantalla_inicial.setText(resultado + "");
    resultado = 0;
  }
    
    else if(op.equals("Borrar")) {
       pantalla_inicial.setText("");
       numeroUno = numeroDos = resultado = 0;
    }
    else {
       pantalla_inicial.setText(pantalla_inicial.getText() + op);
    }
}

public static void main(String args[]) {
    Calculadora_awt m = new Calculadora_awt();
    m.setTitle("Calculadora");
    m.setSize(250,300);
    m.setVisible(true);
    }
}