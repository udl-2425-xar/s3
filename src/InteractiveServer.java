import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class InteractiveServer {
    private static int port = 1213;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("A la espera de connexions.");

            for(;;){
                System.out.println("A la espera d'un nou client");
                Socket socket = ss.accept();

                // crea el thread i fa que atengui al client
                // TODO
                System.out.println("Ha arribat un client");
                System.out.println(socket.getInetAddress().getHostAddress());

                String entrada = "";
                // llegir de l'input
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // tancar el client si ha enviat "FI"
                while(!entrada.equals("FI")){
                    entrada = dis.readUTF();
                    System.out.println("He llegit:" + entrada);
                    // passar a majúscula
                    String sortida = entrada.toUpperCase();
                    // enviar-ho per output
                    dos.writeUTF(sortida);
                    System.out.println("He enviat:" + sortida);
                }
                System.out.println("El client ha decidit tancar la connexió. Tanco canals i socket");
                dis.close();
                dos.close();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
