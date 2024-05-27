
package modelo;


public class Sustancia {
    
    private int Codigo;
    private String Nombre;
    private int Gramos;

    public Sustancia() {
    }

    public Sustancia(int Codigo, String Nombre, int Gramos) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Gramos = Gramos;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getGramos() {
        return Gramos;
    }

    public void setGramos(int Gramos) {
        this.Gramos = Gramos;
    }

    @Override
    public String toString() {
        return "Codigo: " + Codigo + 
               "Nombre: " + Nombre +
               "Gramos: " + Gramos;
    }
    
    
    
}
