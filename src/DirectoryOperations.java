import java.io.File;

public class DirectoryOperations {
    public void createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdir()) {
            System.out.println("Diretorio criado com sucesso.");
        } else {
            System.out.println("Erro ao criar diretorio.");
        }
    }

    public void deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.delete()) {
            System.out.println("Diretorio deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar diretorio.");
        }
    }

    public void listDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            String[] files = dir.list();
            assert files != null;
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("arquivo informado não é um diretorio.");
        }
    }
}
