import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ColaServicio {
    ArrayList<Ticket> cola =new ArrayList<>();

    Date fecha =new Date();
    Scanner entrada = new Scanner(System.in);
    //constructor.
    public ColaServicio() {
    }

    public void EscalarTicket(Ticket ticket){
        ticket.setEstado(TipoEvento.Asignado);
        ticket.setCola(TipoCola.Mesa);
        Bitacora bitacora=Bitacora.generarEventoBitacora(ticket.getId(),ticket.getNitUsuario(),"Ticket fue asignado a MESA DE AYUDA",fecha,TipoEvento.Asignado);

    }

    public void resolver(Ticket ticket){

    }


}
