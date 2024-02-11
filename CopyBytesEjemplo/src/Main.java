import java.io.*;

public class Main {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Error de sintaxis. Se necesitan dos argumentos");
            return;
        }
        final int TAM = 1024 * 16;

        try (
                BufferedInputStream bin=new BufferedInputStream(new FileInputStream("openwebinars.jpg"));
                BufferedOutputStream bout =new BufferedOutputStream(new FileOutputStream("openwebinars.jpg"))
        ){
            int cantidadBytes = 0;
            byte[] buffer = new byte[TAM];

            while ((cantidadBytes = bin.read(buffer, 0, TAM)) != -1) {
                bout.write(buffer, 0, cantidadBytes);
            }
            System.out.println("El fichero se ha copiado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}