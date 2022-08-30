import java.util.*;

//este proyecto va dedicado a la discografia de Taylor Swift y al cafe <3
//que fueron los unicos que me acompañaron a realizarlo <3
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Date fecha=new Date();
        //objetos de las diferentes colas
        ColaServicio colaServicio= new ColaServicio();
        ColaServicio colaMesa=new ColaMesa();
        ColaServicio colaSoporte=new ColaSoporte();
        ColaDesarrollo colaDesarrollo=new ColaDesarrollo();
        //-----------------------------------

        //listas de las diferentes colas
        ArrayList<Ticket> ticketss=new ArrayList<>();
        Queue<Ticket> ColaMesa = new LinkedList<>();
        Stack <Ticket> PilaSoporte = new Stack<>();
        ArrayList<Ticket> listaDesarrollo=new ArrayList<>();
        ArrayList<Ticket> ColaAtendidos =new ArrayList<>();
        //--------------------------------------


        int contMesa=1,contSoporte=1,contDesarrollo=1;
        char salir;
        do {




            System.out.println("Si usted es usuario ingrese 1 "+
                    "\nsi usted es tecnico ingrese 2 " +
                    "\n3. Mostrar");


            int ingreso=entrada.nextInt();
            if (ingreso==1){
                System.out.println("Ingrese su Ticket" );
                System.out.println("----------------------");
                System.out.println("Ingrese su numero de NIT");
                String nitUsuario =entrada.next();
                System.out.println("Describa su problema");

                String problema=entrada.next();


                Ticket tickets=Ticket.generarTicket(nitUsuario,problema,TipoEvento.Crear,TipoCola.Mesa);
                ticketss.add(tickets);


                System.out.println("SE GENERA NUEVO EVENTO EN LA BITACORA");
                Bitacora bitacora=Bitacora.generarEventoBitacora(tickets.getId(),tickets.getNitUsuario(),"ticket creado",fecha,TipoEvento.Crear);
                tickets.agregarBitacora(bitacora);

            } else if (ingreso==2) {

                System.out.println("Bienvenido");
                System.out.println("ingresa tu nit");
                String nitSoporte =entrada.next();
                System.out.println("cual es tu area" +
                        "\n1. Mesa de ayuda" +
                        "\n2. Soporte tecnico" +
                        "\n3. Desarollo");
                int cola =entrada.nextInt();


                switch (cola){
                    case 1:
                        for (int i = 0; i < ticketss.size() ; i++) {
                            if (ticketss.get(i).getId()==contMesa&&ticketss.get(i).getCola()==TipoCola.Mesa){
                                ColaMesa.offer(ticketss.get(i));
                            }

                        }
                        System.out.println("COLA MESA DE AYUDA");
                        System.out.println("Tenemos este ticket en cola");
                        System.out.println(ColaMesa.peek());
                        System.out.println("Que deseas hacer con el ticket?" +
                                "\n1. Escalarlo" +
                                "\n2. Resolverlo");
                        int hacer =entrada.nextInt();

                        switch (hacer){
                            case 1:
                                System.out.println("SE ESCALA EL TICKET");
                                colaMesa.EscalarTicket(ColaMesa.peek());
                                ColaMesa.peek().setCola(TipoCola.Soporte);

                                ColaMesa.poll();

                                break;
                            case 2:
                                System.out.println("SE RESUELVE EL TICKET");
                                colaMesa.resolver(ColaMesa.peek());
                                ColaAtendidos.add(ColaMesa.peek());
                                ColaMesa.poll();
                        }
                        contMesa++;
                        break;
                    case 2:
                        for (int i = 0; i < ticketss.size() ; i++) {
                            if (ticketss.get(i).getId()==contSoporte&&ticketss.get(i).getCola()==TipoCola.Soporte){
                                PilaSoporte.push(ticketss.get(i));
                            }
                        }
                        System.out.println("COLA MESA DE SOPORTE");
                        System.out.println("Tenemos esto en cola");
                        System.out.println(PilaSoporte.peek());
                        System.out.println("Que deseas hacer con el ticket?" +
                                "\n1. Escalarlo" +
                                "\n2. Resolverlo");
                         hacer =entrada.nextInt();
                        switch (hacer) {
                            case 1:
                                System.out.println("SE ESCALA EL TICKET");
                                colaSoporte.EscalarTicket(PilaSoporte.peek());
                                PilaSoporte.peek().setCola(TipoCola.Desarrollo);
                                PilaSoporte.pop();
                                break;
                            case 2:
                                System.out.println("SE RESUELVE EL TICKET");
                                colaSoporte.resolver(PilaSoporte.peek());
                                ColaAtendidos.add(PilaSoporte.peek());
                                PilaSoporte.pop();
                        }
                        contSoporte++;
                        break;
                    case 3:
                        for (int i = 0; i < ticketss.size() ; i++) {
                            if (ticketss.get(i).getId()==contDesarrollo&&ticketss.get(i).getCola()==TipoCola.Desarrollo){
                                listaDesarrollo.add(ticketss.get(i));
                            }
                        }
                        System.out.println("tenemos este ticket esperando solucion");



                       for (int i = 0; i <listaDesarrollo.size(); i++) {

                            int index =(int)(Math.random()*listaDesarrollo.size()+1);

                            System.out.println("el ticket para resolver es: "+listaDesarrollo.get(index));


                            colaDesarrollo.resolver(listaDesarrollo.get(index));
                            listaDesarrollo.remove(index);
                            ColaAtendidos.add(listaDesarrollo.get(index));

                            break;

                        }

                        break;

                }


            } else if (ingreso==3) {
                System.out.println("1. Mostrar contenido de las diferentes colas " +
                        " \n2. Mostrar lista total de tickets creados " +
                        "\n3. Mostrar bitacora");

                        int opcion=entrada.nextInt();
                        switch (opcion){
                            case 1:
                                System.out.println("COLA DE MESA DE AYUDA");
                                for (Ticket mostrar:ColaMesa) {
                                    System.out.println(mostrar.toString());
                                }
                                System.out.println("COLA MESA DE SOPORTE");
                                for (Ticket mostrar:PilaSoporte) {
                                    System.out.println(mostrar.toString());
                                }
                                System.out.println("COLA MESA DE DESARROLLO");
                                for (Ticket mostrar:listaDesarrollo) {
                                    System.out.println(mostrar.toString());
                                }
                                System.out.println("LISTA DE TODOS LOS TICKETS ATENDIDOS");
                                for (Ticket mostrar:ColaAtendidos) {
                                    System.out.println(mostrar.toString());
                                }
                                break;
                            case 2:
                                System.out.println("Lista tickets creados");
                                for (Ticket mostrar:ticketss) {
                                    System.out.println(mostrar.toString());
                                }
                                break;
                            case 3:
                                Ticket ticket=new Ticket();
                                ticket.mostrarBitacora();
                                break;




                        }




            }


            System.out.println("Escriba 1 si desea continuar en el programa");
            salir = entrada.next().charAt(0);

        } while (salir == '1');




    }
}
