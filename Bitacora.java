import java.util.Date;


public class Bitacora {

    private static int correlativo=1;
    private int id;
    private String nitSoporte;
    private String mensaje;

    private Date fechaYHora;


    TipoEvento evento;




    public Bitacora() {
        id=correlativo;
        correlativo++;
    }

    private Bitacora(int idd,String nitSoporte, String mensaje, Date fechaYHora, TipoEvento evento) {
        id=correlativo;
        correlativo++;
        this.id=idd;
        this.nitSoporte = nitSoporte;
        this.mensaje=mensaje;
        this.fechaYHora = fechaYHora;

        this.evento = evento;
    }

    public void bitacora(){

    }
    public static Bitacora generarEventoBitacora(int idd,String nitSoporte, String mensaje, Date fechaYHora, TipoEvento evento ){

        return new Bitacora(idd,nitSoporte,mensaje,fechaYHora,evento);


    }


    @Override
    public String toString() {
        return "Bitacora{" +
                "id=" + id +
                ", nitSoporte='" + nitSoporte + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaYHora=" + fechaYHora +
                ", evento=" + evento +
                '}';
    }
}
