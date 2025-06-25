
/**
 *Implemente un sistema de envío de mensajes a móviles. 
 * Existen dos tipos de mensajes que se pueden enviar entre móviles, mensajes de texto (SMS) 
 * y mensajes que contienen imágenes (MMS). Por un lado, los mensajes de texto contienen un mensaje en caracteres que 
 * se desea enviar de un móvil a otro. Por otro lado, los mensajes que contienen imágenes almacenan información 
 * sobre la imagen a enviar, la cual se representará por el nombre del fichero que la contiene. 
 * Independientemente del tipo de mensaje, cada mensaje tendrá asociado un remitente de dicho mensaje y un destinatario. 
 * Ambos estarán definidos obligatoriamente por un número de móvil, y opcionalmente se podrá guardar información 
 * sobre su nombre. Además, los métodos enviarMensaje y visualizarMensaje deben estar definidos.
Note
 *Para probar el diseño jerarquico de clases, instancia en el clase de prueba Ejecutor, con datos ficticios.
 * @author franc
 */

public class Problema_3MensajesMoviles {
    public static void main(String[] args) {

        SMS sms1 = new SMS("123456789", "987654321", "¿Vamos al cine?");
        sms1.nombreRemitente = "Alice";
        
        MMS mms1 = new MMS("555111222", "555333444", "foto_vacaciones.jpg");
        mms1.nombreRemitente = "Bob";
        mms1.nombreDestinatario = "Carlos";

        System.out.println("Remitente del SMS: " + sms1.remitente);

        sms1.enviarMensaje();
        System.out.println(mms1.visualizarMensaje());
    }
}

class Mensaje {
    public String remitente;
    public String destinatario;
    public String nombreRemitente;
    public String nombreDestinatario;

    public Mensaje(String remitente, String destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje() {
        System.out.println("Enviando mensaje genérico...");
    }

    public String visualizarMensaje() {
        return "Mensaje de " + remitente + " a " + destinatario;
    }
}

class SMS extends Mensaje {
    public String texto;

    public SMS(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS a " + destinatario + ": " + texto);
    }

    @Override
    public String visualizarMensaje() {
        return "SMS de " + nombreRemitente + " (" + remitente + "): " + texto;
    }
}


class MMS extends Mensaje {
    public String nombreFicheroImagen;

    public MMS(String remitente, String destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS con imagen '" + nombreFicheroImagen + "' a " + destinatario);
    }

    @Override
    public String visualizarMensaje() {
        return "MMS de " + nombreRemitente + " (" + remitente + "): " + nombreFicheroImagen;
    }
}