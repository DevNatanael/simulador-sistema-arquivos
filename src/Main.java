import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileOperations fileOps = new FileOperations();
        DirectoryOperations dirOps = new DirectoryOperations();
        JournalManager journal = new JournalManager();

        System.out.println("Simulador de sistema de arquivos");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Arquivos txt");
            System.out.println("2 - Diretórios");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 0) {
                System.out.println("Saindo do simulador...");
                break;
            }

            switch (choice) {
                case 1:
                    handleFileOperations(scanner, fileOps);
                    break;
                case 2:
                    handleDirectoryOperations(scanner, dirOps);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void handleFileOperations(Scanner scanner, FileOperations fileOps) {
        System.out.println("Escolha uma operação de arquivo:");
        System.out.println("1 - Copiar arquivo");
        System.out.println("2 - Apagar arquivo");
        System.out.println("3 - Renomear arquivo");
        System.out.print("Opção: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Digite o caminho do arquivo de origem (ex: C:\\\\Users\\\\Desktop\\\\texte.txt): ");
                String src = scanner.nextLine();
                System.out.print("Digite o diretório de destino: ");
                String dest = scanner.nextLine();
                fileOps.copyFile(src, dest);
                break;
            case 2:
                System.out.print("Digite o caminho do arquivo a ser apagado (ex: C:\\\\Users\\\\Desktop\\\\texte.txt): ");
                String filePath = scanner.nextLine();
                fileOps.deleteFile(filePath);
                break;
            case 3:
                System.out.print("Digite o caminho do arquivo a ser renomeado (ex: C:\\\\Users\\\\Desktop\\\\texte.txt): ");
                String oldName = scanner.nextLine();
                System.out.print("Digite o novo nome do arquivo: ");
                String newName = scanner.nextLine();
                fileOps.renameFile(oldName, newName);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void handleDirectoryOperations(Scanner scanner, DirectoryOperations dirOps) {
        System.out.println("Escolha uma operação de diretório:");
        System.out.println("1 - Criar diretório");
        System.out.println("2 - Apagar diretório");
        System.out.println("3 - Renomear diretório");
        System.out.println("4 - Listar arquivos de um diretório");
        System.out.print("Opção: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Digite o caminho com o nome do novo diretório (ex: C:\\\\Users\\\\Desktop\\\\novo\\\\): ");
                String dirPath = scanner.nextLine();
                dirOps.createDirectory(dirPath);
                break;
            case 2:
                System.out.print("Digite o caminho do diretório a ser apagado (ex: C:\\\\Users\\\\Desktop\\\\teste\\\\): ");
                String delDirPath = scanner.nextLine();
                dirOps.deleteDirectory(delDirPath);
                break;
            case 3:
                System.out.print("Digite o caminho do diretório a ser renomeado (ex: C:\\\\Users\\\\Desktop\\\\teste\\\\): ");
                String oldDirPath = scanner.nextLine();
                System.out.print("Digite o novo nome do diretório: ");
                String newDirPath = scanner.nextLine();
                dirOps.renameDirectory(oldDirPath, newDirPath);
                break;
            case 4:
                System.out.print("Digite o caminho do diretório a ser listado (ex: C:\\\\Users\\\\Desktop\\\\teste\\\\): ");
                String listDirPath = scanner.nextLine();
                dirOps.listDirectory(listDirPath);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
