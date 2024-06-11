import java.io.File;

public class DirectoryOperations {
    private JournalManager journal = new JournalManager();

    public void createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.mkdir()) {
            System.out.println("Diretorio criado com sucesso.");
            journal.logOperation("Criando diretorio em: " + dirPath);
        } else {
            System.out.println("Erro ao criar diretorio.");
        }
    }

    public void deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.delete()) {
            System.out.println("Diretorio deletado com sucesso.");
            journal.logOperation("Apagando diretorio: " + dirPath);
        } else {
            System.out.println("Erro ao deletar diretorio.");
        }
    }

    public void renameDirectory(String oldPath, String newDirName) {
        File oldDir = new File(oldPath);
        String oldDirPath = oldDir.getPath();

        int lastSeparatorIndex = oldDirPath.lastIndexOf("\\");
        String newDirPath = oldDirPath.substring(0, lastSeparatorIndex + 1);
        newDirPath += newDirName;

        File newDir = new File(newDirPath);

        if (!oldDir.exists()) {
            System.out.println("Diretorio informado não existe.");
            return;
        }

        if (newDir.exists()) {
            System.out.println("Nome de diretorio escolhido já existe.");
            return;
        }

        if (oldDir.renameTo(newDir)) {
            System.out.println("Diretorio renomeado com sucesso.");
            journal.logOperation("renomeando diretorio " + oldDirPath + " para " + newDirName);
        } else {
            System.out.println("Erro ao renomear diretorio.");
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
            journal.logOperation("listando diretorio em: " + dirPath);
        } else {
            System.out.println("arquivo informado não é um diretorio.");
        }
    }
}
