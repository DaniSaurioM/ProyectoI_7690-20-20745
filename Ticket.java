import java.util.ArrayList;

public class Ticket {
    //atributtes
    private String nitUsuario;

    private static int correlativo=1;
    private int id;
    private String problema;
    private TipoEvento estado;
    private TipoCola cola;

    ArrayList<Bitacora> bitacoras =new ArrayList<>();
    //-------------



    private Ticket(String nitUsuario, String problema, TipoEvento estado, TipoCola cola) {
        id=correlativo;
        correlativo++;
        this.nitUsuario = nitUsuario;
        this.problema = problema;
        this.estado = estado;
        this.cola=cola;
    }

    public Ticket() {

    }

    public static Ticket generarTicket(String nitUsuario, String problema, TipoEvento estado, TipoCola cola){

        return new Ticket(nitUsuario,problema,estado,cola);


    }



    public void agregarBitacora(Bitacora bitacora){
        bitacoras.add(bitacora);

    }
    public void mostrarBitacora(){
        for (Bitacora mostrar:bitacoras) {
            System.out.println(mostrar.toString());
        }
    }







    //getters

    public String getNitUsuario() {
        return nitUsuario;
    }

    public String getProblema() {
        return problema;
    }

    public TipoEvento getEstado() {
        return estado;
    }

    public TipoCola getCola() {
        return cola;
    }

    public int getId() {
        return id;
    }
    //-------

    //setters

    public void setEstado(TipoEvento estado) { this.estado = estado; }

    public void setCola(TipoCola cola) { this.cola = cola; }
    //--------------------------


    @Override
    public String toString() {
        return "Ticket{" +
                "nitUsuario='" + nitUsuario + '\'' +
                ", id=" + id +
                ", problema='" + problema + '\'' +
                ", estado=" + estado +
                ", cola=" + cola +
                '}';
    }
}
