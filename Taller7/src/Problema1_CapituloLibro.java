
import java.util.ArrayList;
import java.util.List;


/**
 * Dibujad un diagrama de clases que muestre la estructura de un capítulo de libro; 
 * un capítulo está compuesto por varias secciones, cada una de las cuales comprende varios párrafos y figuras. 
 * Un párrafo incluye varias sentencias, cada una de las cuales contiene varias palabras.
Note
 *Suponga que en un futuro se prevé que el sistema gestione además de párrafos y figuras otros componentes, como tablas, listas, viñetas, etc.
 *Suponga además que una palabra puede aparecer en varias sentencias.
 *
 * @author Francis Tapia
 */

public class Problema1_CapituloLibro {

    public static void main(String[] args) {
        
        Palabra palabra1 = new Palabra("Hola");
        Palabra palabra2 = new Palabra("mundo");
        
        Sentencia sentencia1 = new Sentencia();
        sentencia1.palabras.add(palabra1);
        sentencia1.palabras.add(palabra2);
        
        Parrafo parrafo1 = new Parrafo();
        parrafo1.sentencias.add(sentencia1);
        
        Figura figura1 = new Figura("imagen1.png"); // Sin leyenda
        
        Seccion seccion1 = new Seccion("Introducción");
        seccion1.elementos.add(parrafo1);
        seccion1.elementos.add(figura1);
        
        Capitulo capitulo1 = new Capitulo("Capítulo 1");
        capitulo1.secciones.add(seccion1);
        
        System.out.println(capitulo1);
    }
}

class Capitulo {
    String titulo;
    List<Seccion> secciones = new ArrayList<>();

    public Capitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "titulo=" + titulo + ", secciones=" + secciones + '}';
    }
}

class Seccion {
    String titulo;
    List<Seccion> elementos = new ArrayList<>();

    public Seccion(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Seccion{" + "titulo=" + titulo + ", elementos=" + elementos + '}';
    }
}

class Parrafo extends Seccion {
    List<Sentencia> sentencias = new ArrayList<>();

    public Parrafo() {
        super("");
    }
}

class Figura extends Seccion {
    String rutaImagen;

    public Figura(String rutaImagen) {
        super("");
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Figura{" + "rutaImagen=" + rutaImagen + '}';
    }
}

class Sentencia {
    List<Palabra> palabras = new ArrayList<>();

    @Override
    public String toString() {
        return "Sentencia{" + "palabras=" + palabras + '}';
    }
}

class Palabra {
    String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Palabra{" + "texto=" + texto + '}';
    }
}

