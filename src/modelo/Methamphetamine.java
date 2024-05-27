
package modelo;


public class Methamphetamine extends Sustancia{
    
    private int Pureza;
    private String Color;

    public Methamphetamine() {
    }

    public Methamphetamine(int Pureza, String Color, int Codigo, String Nombre, int Gramos) {
        super(Codigo, Nombre, Gramos);
        this.Pureza = Pureza;
        this.Color = Color;
    }

    public int getPureza() {
        return Pureza;
    }

    public void setPureza(int Pureza) {
        this.Pureza = Pureza;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public int getCodigo() {
        return super.getCodigo(); 
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }

    @Override
    public int getGramos() {
        return super.getGramos(); 
    }

    @Override
    public String toString() {
        return super.toString() +
        "Pureza: " + Pureza +
        "Color: " +Pureza;
    }
    
    
    
    
}
