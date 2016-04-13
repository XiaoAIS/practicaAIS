package calculadora;

import javax.swing.JFrame;

public class Ventana_principal extends JFrame{

    public Ventana_principal(Operador op){  
            
            this.setResizable(true);//para que la ventana es modificable su tamaño
            
            this.setContentPane(new panel_calculadora(op));
            
            this.setTitle("Calculadora");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(300, 200);
            this.setLocationRelativeTo(this);//cuando abierto , la ventana principal se coloca en el centro de ventana 
            
            this.setVisible(true);
    }
    
}
