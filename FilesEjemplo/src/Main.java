import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        /*
        Path p1 = Paths.get("file.txt");

        if (Files.notExists(p1)) {
            System.out.println("La ruta no existe");
            try {
                Files.createFile(p1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (Files.exists(p1))
            System.out.println("La ruta sí existe");

        if (Files.notExists(p1))
            System.out.println("La ruta no existe");

        if (Files.isRegularFile(p1))
            System.out.println("El fichero " + p1.toString() + " es regular");

        Path p2 = Paths.get("file.txt");

        try {
            if (Files.isSameFile(p1, p2))
                System.out.println("Son el mismo fichero");
        } catch (IOException e) {
            e.printStackTrace();
        }
         */

        Path p3 =Paths.get(args[0]);
        try( BufferedWriter bw = Files.newBufferedWriter(p3);){
            bw.write("Curso de Java 8 para programadores Java en www.openwebinars.net");
            bw.close();

            Path copia = Paths.get(args[1]);
            Files.copy(p3, copia, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}