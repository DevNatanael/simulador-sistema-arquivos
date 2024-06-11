import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    private JournalManager journal = new JournalManager();

    public void copyFile(String source, String destination) {
        File srcFile = new File(source);
        File destDir = new File(destination);

        if (!srcFile.exists()) {
            System.out.println("Arquivo de origem não existe.");
            return;
        }

        if (!destDir.exists()) {
            System.out.println("Diretorio de destino não existe.");
            return;
        }

        if (!destDir.isDirectory()) {
            System.out.println("Destino não é um diretorio.");
            return;
        }

        File destFile = new File(destDir, srcFile.getName());
        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("arquivo copiado com sucesso para: " + destFile.getPath());
            journal.logOperation("copiando " + source + " para " + destFile.getPath());
        } catch (IOException e) {
            System.out.println("Erro ao copiar: " + e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Arquivo deletado com sucesso.");
            journal.logOperation("Apagando arquivo: "+ filePath);
        } else {
            System.out.println("Erro ao deletar arquivo.");
        }
    }

    public void renameFile(String pathFile, String newName) {
        File filePath = new File(pathFile);
        String path = filePath.getPath();

        int lastSeparatorIndex = path.lastIndexOf("\\");
        String newFilePath = path.substring(0, lastSeparatorIndex + 1);
        newFilePath += newName + ".txt";

        File newFileName = new File(newFilePath);

        if (filePath.renameTo(newFileName)) {
            System.out.println("Arquivo renomeado com sucesso.");
            journal.logOperation("renomeando arquivo " + path + " para " + newFilePath);
        } else {
            System.out.println("Erro ao renomear arquivo");
        }
    }
}
