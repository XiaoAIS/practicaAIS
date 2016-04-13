
package calculadora;

public class Operador {
    private double operador1;
    private double operador2;

    public double getOperador1() {
        return operador1;
    }

    public double getOperador2() {
        return operador2;
    }


    public void setOperador1(double operador1) {
        this.operador1 = operador1;
    }

    public void setOperador2(double operador2) {
        this.operador2 = operador2;
    }
    //operaciones 
    public double suma(){
        return (this.operador1+this.operador2);
    }
    
    public double resta(){
        return (this.operador1-this.operador2);
    }
    
    public double multiplica(){
        return (this.operador1*this.operador2);
    }
    
    public double division(){
        return (this.operador1/this.operador2);
    }
}
