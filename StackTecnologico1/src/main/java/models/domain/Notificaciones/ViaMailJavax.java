package models.domain.Notificaciones;


import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.util.Properties;


public class ViaMailJavax implements AdapterViaMail{
  private String remitente = "disenioGrupo9@gmail.com";
  private String claveemail = "bwlmzwnlroykvjas"; //clave de aplicacion

  public void recibirNotificacion(String mensaje, String mailDestinatario, String asunto){

  }
  public void enviarArchivo(String ruta, String mailDestinatario, String asunto){
  }
}