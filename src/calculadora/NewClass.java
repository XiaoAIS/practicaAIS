/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author xiaos
 */
public class NewClass {
    
    
    public static void main(String args[]){
        Pila pila=new Pila();
        String a="anc";
        String c="cb";
        pila.apilar(a);
        pila.apilar(c);
        a.concat(pila.contenido[0]);
        String c1=pila.toString();
        
    }
}
