import java.io.*;
import java.net.Socket;

public class HowlerClient {

    private static String host = "localhost";
    private static int port = 1213;

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // adreça des del primer paràmetre si existeix
        if (args.length > 0){
            host = args[0];
        }

//        lectura de la consola
//        lectura no válida
//        InputStream is = System.in;
//        DataInputStream dis = new DataInputStream(is);
//        no funciona, no llegeix salts de línia
//          dis.readUTF();
//        no funciona, no llegeix bé caràcters amb accent
//            String lectura = dis.readLine();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {

            // Creació de socket
            Socket s = new Socket(host, port);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String lectura = "";
            String cadenaDeRetorn;

            // fer bucle: mentre cadena llegida != FI
            // enviar cadena, llegir retorn i pintar-lo per consola
            while(!lectura.equals("FI")){
                System.out.println("Escriu algun missatge per enviar-lo al server i que l'UPPER-itzi:");
                lectura = br.readLine();
                dos.writeUTF(lectura);
                dos.flush();
                cadenaDeRetorn = dis.readUTF();
                System.out.println("El servidor ha tornat: " + cadenaDeRetorn);
            }

            dis.close();
            dos.close();
            br.close();
            s.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}