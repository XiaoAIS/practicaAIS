package calculadora;
import java.awt.*;
import static java.awt.BorderLayout.NORTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class panel_calculadora extends JPanel{
    //variable local que ayudar a recoger datos 
    private String num1="0";
    private String num2="0";
    private int datoEscrito=0;
    private boolean puntoEscrito=false;
    private boolean fin=false;//si llega a fin de una operacion
    private StringBuffer datoImprimir=new StringBuffer("0");//mensaje a escribir en la pantalla cuando teclea
    private String resultado;
    private char simb_op='0';//simbolo de operador
    //variable para interfaz e para objeto de otra clase
    private Operador operador;
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bsum,bres,bmul,bdiv,breset,beliminar,bresultado,bpunto;
    private JTextField pantalla;
    //private JLabel pantalla;
   


    
    panel_calculadora(Operador op) {

        
        this.operador=op;
        this.setLayout(new BorderLayout());//convertir primero en BorderLayout
        this.pantalla=new JTextField();
        this.pantalla.setHorizontalAlignment(SwingConstants.RIGHT);//para que escribe letras desde derecha 
        this.pantalla.setEditable(false);//para que el usuario no mete cosa en el campo de texto directamente 
        this.pantalla.setBackground(Color.WHITE);//establecer el campo en color blanco 
        //this.pantalla=new JLabel(".");
        //this.pantalla.setHorizontalTextPosition(RIGHT);
       // this.pantalla.setSize(100,100);
        this.add(this.pantalla,NORTH);
        //establece un panel para colocar resto de botones con nuevo layout
        JPanel panelBoton=new JPanel();
        panelBoton.setLayout(new GridLayout(5,4) );//una matriz
        this.breset=new JButton("CE");
        this.beliminar=new JButton("<=");
        this.bsum=new JButton("+");
        this.bres=new JButton("-");
        this.bmul=new JButton("*");
        this.bdiv=new JButton("/");
        this.bresultado=new JButton("=");
        this.bpunto=new JButton(".");
        this.b0=new JButton("0");
        this.b1=new JButton("1");
        this.b2=new JButton("2");
        this.b3=new JButton("3");
        this.b4=new JButton("4");
        this.b5=new JButton("5");
        this.b6=new JButton("6");
        this.b7=new JButton("7");
        this.b8=new JButton("8");
        this.b9=new JButton("9");
        panelBoton.add(this.breset);
        panelBoton.add(this.beliminar);
        panelBoton.add(this.bdiv);
        panelBoton.add(this.bmul);
        panelBoton.add(this.b7);
        panelBoton.add(this.b8);
        panelBoton.add(this.b9);
        panelBoton.add(this.bres);
        panelBoton.add(this.b4);
        panelBoton.add(this.b5);
        panelBoton.add(this.b6);
        panelBoton.add(this.bsum);
        panelBoton.add(this.b1);
        panelBoton.add(this.b2);
        panelBoton.add(this.b3);
        panelBoton.add(this.bresultado);
        panelBoton.add(this.b0);
        panelBoton.add(this.bpunto);
        this.add(panelBoton);//establece este panel al resto de borderlayout del panel_calculadora
        //gestion de eventos
        ActionListener gestor_evento_click=new ActionListener() {//un objeto ActionListener para implementar e gestionar eventos click
            @Override
            public void actionPerformed(ActionEvent e) {
                fin=false;//cuando vuelve a empezar 
                String comando=e.getActionCommand();//conseguir lo que acaba de teclea
                System.out.println(comando);//aux
                procesarComando(comando);
                
            }
        };//fin de ActionListener
        
        
        //gestor para teclado
        KeyListener gestor_teclado=new KeyListener(){

            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                    

                fin=false;//cuando vuelve a empezar
                System.out.println("codigo="+ke.getKeyCode());//aux
                System.out.println("teclado"+ke.getKeyChar());//
                char key=(char)ke.getKeyChar();//conseguir codigo teclado
                doClick(key);//lo manda para procesar
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
            
        };
        this.addKeyListener(gestor_teclado);//ajustar a panel para que escuche a teclado
                                this.setFocusable(true);

        //hace que los botones eschucha eventos
        this.b0.addActionListener(gestor_evento_click);
        this.b1.addActionListener(gestor_evento_click);
        this.b2.addActionListener(gestor_evento_click);
        this.b3.addActionListener(gestor_evento_click);
        this.b4.addActionListener(gestor_evento_click);
        this.b5.addActionListener(gestor_evento_click);
        this.b6.addActionListener(gestor_evento_click);
        this.b7.addActionListener(gestor_evento_click);
        this.b8.addActionListener(gestor_evento_click);
        this.b9.addActionListener(gestor_evento_click);
        this.breset.addActionListener(gestor_evento_click);
        this.bdiv.addActionListener(gestor_evento_click);
        this.bmul.addActionListener(gestor_evento_click);
        this.bsum.addActionListener(gestor_evento_click);
        this.bres.addActionListener(gestor_evento_click);
        this.bresultado.addActionListener(gestor_evento_click);
        this.beliminar.addActionListener(gestor_evento_click);
        this.bpunto.addActionListener(gestor_evento_click);
    }//fin de constructor

    //metodo auxiliar
    private void reiniciar(){
        //reinicia todo
        this.num1="0";
        this.num2="0";
        this.datoImprimir=new StringBuffer("0");
        this.datoEscrito=0;
        this.puntoEscrito=false;
        this.resultado="0";
        this.fin=false;
    }
    
     //metodo auxiliar para gestionar cuando recibe un comando
    private void procesarComando(String comando){
        System.out.println("estoy en procesarcomando"+comando);//aux
       boolean siAniade =true;//si puede añadir este simbolo
       this.requestFocus();
        switch(comando){
                    case "0":{ if(datoImprimir.toString().equals("0"))
                               siAniade=false;} ;
                    break;
                    case "1":{ if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "2":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "3":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "4":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "5":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "6":if(datoImprimir.toString().equals("0")){
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "7":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "8":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "9":{if(datoImprimir.toString().equals("0"))
                               datoImprimir.deleteCharAt(0);}
                    break;
                    case "CE":{siAniade=false;
                                reiniciar();}
                    break;
                    case "<=":{siAniade=false;
                               if(datoImprimir.length()>1){//si la longitud puede eliminar 1
                                      String n_a_eliminar=datoImprimir.substring(datoImprimir.length()-1);
                                      System.out.println(n_a_eliminar);//aux
                                      //si detecta que lo que elimina es siguiente simbolo, hace esto
                                      switch(n_a_eliminar){
                                          case ".":puntoEscrito=false;
                                          break;
                                          case "+":;
                                          case "-":;
                                          case "*":;
                                          case "/": datoEscrito=0;    
                                      }
                                      datoImprimir.deleteCharAt(datoImprimir.length()-1);
                                       
                                      }
                               else datoImprimir=new StringBuffer("0");}//la longitud es minima ya
                    break;
                    case "/":{simb_op=comando.charAt(0);//guarda el simbolo en variable tipo char
                               if(datoEscrito==0){//si anteriormente no ha pulsado ningun simbolo de operacion para guardar datos
                               num1=datoImprimir.toString();
                               operador.setOperador1(Double.parseDouble(num1));
                               datoEscrito=1;
                               this.puntoEscrito=false;
                               }
                               else siAniade=false; //si anteriormente ha tecleado algun simbolo de operacion se considera invalido
                               }
                    break;
                    case "*":{simb_op=comando.charAt(0);
                               if(datoEscrito==0){
                               num1=datoImprimir.toString();
                               operador.setOperador1(Double.parseDouble(num1));
                               datoEscrito=1;
                                this.puntoEscrito=false;
                               }
                               else siAniade=false; }
                    break;
                    case "-":{simb_op=comando.charAt(0);
                            if(datoEscrito==0){
                               num1=datoImprimir.toString();
                               operador.setOperador1(Double.parseDouble(num1));
                               datoEscrito=1;   
                               this.puntoEscrito=false;
                               }
                               else siAniade=false; }
                    break;
                    case "+":{simb_op=comando.charAt(0);
                            if(datoEscrito==0){
                               num1=datoImprimir.toString();
                                System.out.println(num1);
                               operador.setOperador1(Double.parseDouble(num1));
                               datoEscrito=1;
                               this.puntoEscrito=false;
                                }
                               else siAniade=false; }
                    break;
                    case "=":{ 
                              siAniade=false;
                              if(datoEscrito==0){//si no ha escrito nada en num1 antes de pulsa =
                                  num1="0";
                                  datoImprimir=new StringBuffer(num1);
                              }
                              else{//para obtener cadena de num2
                              if(datoImprimir.length()>1)   
                               num2=datoImprimir.substring(num1.length()+1,datoImprimir.length());
                              }
                               try{ operar();
                        }catch(NumberFormatException e){
                                reiniciar();
                                }
                            }
                    break;
                    case ".":{ 
                               if(!puntoEscrito)//si ha escrito un punto
                               puntoEscrito=true;
                                else siAniade=false; }
                    
                }
                //si puede añadir
                if(siAniade) 
                datoImprimir.append(comando);
                pantalla.setText(datoImprimir.toString());
                if(fin){
                //imprime por pantalla resultado
                pantalla.setText(resultado);
                reiniciar();
                }
    };
    
    
    
    //metodo auxiliar para llevar a cabo una operacion
    private void operar(){
        System.out.println("num1:"+num1+",  num2:"+num2+"operador:"+simb_op);//aux
        operador.setOperador1(Double.parseDouble(num1));
        operador.setOperador2(Double.parseDouble(num2));
        double res=0;
        
        System.out.println("operador clase: "+operador.getOperador1()+",,"+operador.getOperador2());//aux
        switch(simb_op){
            case '/':{res=operador.division();}
            break;
            case '*':{res=operador.multiplica();}
            break;
            case '-':{res=operador.resta();}
            break;
            case '+':{res=operador.suma();}
            break; 
        }
        this.resultado=Double.toString(res);
        System.out.println("resultado:"+resultado);//aux
        fin=true;
    }
    
    private void doClick(char key){
        switch(key){
            case KeyEvent.VK_ENTER:procesarComando("=");
             break;
            case KeyEvent.VK_0 :procesarComando("0");
             break;
            case KeyEvent.VK_1 :procesarComando("1");
             break;
            case KeyEvent.VK_2 :procesarComando("2");
             break;
            case KeyEvent.VK_3 :procesarComando("3");
             break;
            case KeyEvent.VK_4 :procesarComando("4");
             break;
            case KeyEvent.VK_5 :procesarComando("5");
             break;
            case KeyEvent.VK_6 :procesarComando("6");
             break;
            case KeyEvent.VK_7 :procesarComando("7");
             break;
            case KeyEvent.VK_8 :procesarComando("8");
             break;
            case KeyEvent.VK_9 :procesarComando("9");
             break;
            case '+':procesarComando("+");//no entra***********************
             break;
            case KeyEvent.VK_MINUS :procesarComando("-");
             break;
            case '*' :procesarComando("*");//hay que usar asterisco  no entra********************
             break;
            case KeyEvent.VK_SLASH :procesarComando("/");//no puede usar el de VK_divide
             break;
            case KeyEvent.VK_PERIOD :procesarComando(".");
             break;
            case KeyEvent.VK_BACK_SPACE:procesarComando("<=");
        }
        System.out.println("procesarkey:"+key);
    }
    
    
}
