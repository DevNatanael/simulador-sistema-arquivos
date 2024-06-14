import java.util.Scanner;

public class FileSystemShell {
    private FileSystem fileSystem;
    private Scanner scanner;

    public FileSystemShell(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("Bem vindo ao simulador de sistema de arquivos! \n");
        System.out.println("Para informações sobre os comandos digite: info");
        while (true) {
            System.out.print(fileSystem.getCurrentPath() + " $ ");
            String command = scanner.nextLine();
            fileSystem.performOperation(command);
        }
    }
}
