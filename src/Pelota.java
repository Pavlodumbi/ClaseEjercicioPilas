public class Pelota {

    private String nombre;
    private String color;

    public Pelota(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
    }

    @Override
    public String toString() {
        return ("nombre: " + nombre + "\n" +
                "color: " + color + "\n");

    }
}
