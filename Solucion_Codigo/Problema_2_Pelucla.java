

/**
 * Un videoclub dispone de una serie de películas que pueden estar en DVD (con capacidad en Gb.) 
 * o en VHS (una sola cinta por película y con cierto tipo de cinta magnetica). 
 * De las películas interesa guardar el título, el autor, el año de edición y el idioma (o los idiomas, en caso de DVD). 
 * El precio de alquiler de las películas varía en función del tipo de película.
 * Las DVD siempre son 10% mas caras que las de VHS.
 
 Note
 * Analice los tipos de relación de las siguientes posibles clases: 
 Pelicula, Dvd, Vhs, Soporte, etc, y justifique su diseño.
 * Para probar el diseño jerarquico de clases, instancia en el clase de prueba Ejecutor 
 (la-s clase-s respectiva-s), con datos aleatorios.
 * Los escenarios de prueba pueden darse para el alquiler de una o varias peliculas según la preferencia del usuario.
 
 * @author Francis Tapia
 */

import java.util.ArrayList;
public class Problema_2_Pelucla {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("Stich", "Mateo", 2006);
        Pelicula pelicula2 = new Pelicula("La monja", "Mateo", 1998);
        VHS vhs1 = new VHS("EPS", pelicula1, 1.50);
        System.out.println(vhs1);
    }
}

class SoportePelicula{
    public double precioAlquiler;

    public SoportePelicula(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString() {
        return "SoportePelicula{" + "precioAlquiler=" + precioAlquiler + '}';
    }

}

class DVD extends SoportePelicula{
    public String idioma[];
    public ArrayList<Pelicula> pelicula;
    
    public DVD(String[] idioma, ArrayList<Pelicula> pelicula, double precioAlquiler) {
        super(precioAlquiler);
        this.idioma = idioma;
        this.pelicula = pelicula;
    }
    
    public void calcularPrecioAlquiler(){
        this.precioAlquiler += this.precioAlquiler * 0.1;
    }

    @Override
    public String toString() {
        return "DVD{" + "idioma = " + idioma + ", pelicula = " + pelicula + '}';
    }
    
}

class VHS extends SoportePelicula{
    public String idioma;
    public Pelicula pelicula;

    public VHS(String idioma, Pelicula pelicula, double precioAlquiler) {
        super(precioAlquiler);
        this.idioma = idioma;
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "VHS{" + "idioma =" + idioma + ", pelicula = " + pelicula +  super.toString() + "}";
    }
    
    
}

class Pelicula{
    public String titulo;
    public String autor;
    public int añoEdicion;

    public Pelicula(String titulo, String autor, int añoEdicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoEdicion = añoEdicion;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo =" + titulo + ", autor =" + autor + ", a\u00f1oEdicion =" + añoEdicion + '}';
    }

    
}