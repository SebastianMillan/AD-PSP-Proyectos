import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path p1 = Paths.get("java", "temario.txt");
        Path p2 = FileSystems.getDefault().getPath("java", "temario.txt");
        Path p3 = Paths.get(System.getProperty("user.home"),"documents", "java", "temario.txt");

        System.out.println(p1.toAbsolutePath().toString());
        System.out.println(p2.toAbsolutePath().toString());
        System.out.println(p3.toAbsolutePath().toString());

        System.out.println("-----------------------------");

        Path path = Paths.get(System.getProperty("user.home"),"documents", "java", "temario.txt");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        System.out.println("-----------------------------");

        Path path1 = Paths.get(System.getProperty("user.home"),"documents", "java", "..", "..", "temario.txt");
        System.out.println(path1.toString());

        Path normalized = path1.normalize();
        System.out.println(normalized.toString());


        Path basePath = Paths.get(System.getProperty("user.home"),"documents", "java");
        Path file = Paths.get("temario.txt");

        Path complete = basePath.resolve(file);

        System.out.println(complete.toString());

        System.out.println("-----------------------------");

        Path p5 = Paths.get(System.getProperty("user.home"), "documents", "java", "..", "..", "documents", "java",
                "temario.txt");

        Path p4 = Paths.get(System.getProperty("user.home"), "documents", "java", "temario.txt");

        if (p5.equals(p4))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");

        if (p5.normalize().equals(p4))
            System.out.println("Ahora sí son iguales");
    }
}