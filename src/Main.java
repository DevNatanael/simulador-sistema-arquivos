import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);

        System.out.println("-- Simulador de sistema de arquivos --");
        FileOperations fileOps = new FileOperations();
        DirectoryOperations dirOps = new DirectoryOperations();

        // copiar arquivo
        // fileOps.copyFile("C:\\Users\\TI\\Documents\\Tarefa advpl.txt","C:\\Users\\TI\\Desktop\\");

        // apagar arquvio
        //fileOps.deleteFile("C:\\Users\\TI\\Desktop\\teste.txt");

        // renomear arquivo
        // fileOps.renameFile("C:\\Users\\TI\\Desktop\\teste.txt", "abacaxi");


        // criar diretorio
        //dirOps.createDirectory("C:\\Users\\TI\\Desktop\\diretorioTeste");

        // deletar diretorio
        // dirOps.deleteDirectory("C:\\Users\\TI\\Desktop\\diretorioTeste");

        // renomear diretorio
        dirOps.renameDirectory("C:\\Users\\TI\\Desktop\\canetaAzul", "vozao");

        // listar diretorio
        //dirOps.listDirectory("C:\\Users\\TI\\Desktop\\");
    }
}