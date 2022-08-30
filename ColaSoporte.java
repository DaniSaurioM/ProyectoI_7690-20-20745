import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import java.util.Arrays;
import java.util.Stack;

public class ColaSoporte extends ColaServicio {





    public void EscalarTicket(Ticket ticket){
        ticket.setEstado(TipoEvento.Asignado);
        ticket.setCola(TipoCola.Desarrollo);
        Bitacora bitacora=Bitacora.generarEventoBitacora(ticket.getId(),ticket.getNitUsuario(),"Ticket fue asignado a DESARROLLO",fecha,TipoEvento.Asignado);
        ticket.agregarBitacora(bitacora);
    }

    public void resolver(Ticket ticket){
        System.out.println("Solucionando Ticket");
        System.out.println("Ingrese Mensaje");
        String mensaje = entrada.nextLine();
        Bitacora bitacora=Bitacora.generarEventoBitacora(ticket.getId(),ticket.getNitUsuario(),mensaje,fecha,TipoEvento.Solucion);
        ticket.agregarBitacora(bitacora);
        ticket.setCola(TipoCola.Atendidos);
        ticket.setEstado(TipoEvento.Solucion);


    }

}
