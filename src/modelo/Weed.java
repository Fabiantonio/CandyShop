
package modelo;


public class Weed extends Sustancia{
    
    private String Raza;
    private String Genero;

    public Weed() {
    }

    public Weed(String Raza, String Genero, int Codigo, String Nombre, int Gramos) {
        super(Codigo, Nombre, Gramos);
        this.Raza = Raza;
        this.Genero = Genero;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    @Override
    public int getCodigo() {
        return super.getCodigo(); 
    }

    @Override
    public void setCodigo(int Codigo) {
        super.setCodigo(Codigo); 
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }

    @Override
    public void setNombre(String Nombre) {
        super.setNombre(Nombre); 
    }

    @Override
    public int getGramos() {
        return super.getGramos(); 
    }

    @Override
    public void setGramos(int Gramos) {
        super.setGramos(Gramos);
    }

    @Override
    public String toString() {
        return super.toString() + 
        "Raza: " + Raza +
        "Genero: " + Genero;
    }
    
    
    
    
}
