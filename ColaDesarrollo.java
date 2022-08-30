import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ColaDesarrollo extends ColaServicio {




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
