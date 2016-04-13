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
public class Pila {
    String[] contenido;
    int cima; 
    public Pila() {
        contenido=new String[500];
        this.contenido[0]="0";
        int cima=0;
    }
    
    public void apilar(String e){
        this.contenido[this.cima]=e;
        this.cima=this.cima+1;
    }
    
    public void desapilar(){
        if(this.cima>0)
        this.cima=this.cima-1;
    }
    
    public String toString(){
         String texto="";
        if(this.cima==1){
         texto="0";
        }
        else{ 
        for (int i = 0; i < cima; i++) {
            texto=texto+this.contenido[i];
        }
        }
        return texto;
    }
    
    public void resetear(){
        this.contenido[0]="0";
        cima=0;
        
    }
}
