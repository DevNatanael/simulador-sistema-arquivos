public class FileSystem {
    private Directory root;
    private Directory currentDirectory;
    private Journal journal;
    private String currentPath;

    public FileSystem() {
        root = new Directory("/");
        currentDirectory = root;
        journal = new Journal();
        currentPath = "/";
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(Directory directory) {
        this.currentDirectory = directory;
        updateCurrentPath();
    }

    public void performOperation(String operation) {
        journal.addEntry(operation);
        executeOperation(operation);
    }

    private void executeOperation(String operation) {
        String[] parts = operation.split(" ");
        switch (parts[0]) {
            case "mkdir":
                String dirName = parts[1];
                Directory newDir = new Directory(dirName, currentDirectory);
                currentDirectory.getSubDirectories().put(dirName, newDir);
                journal.logOperation("Criando Diretório: "+ dirName);
                break;
            case "rmdir":
                dirName = parts[1];
                currentDirectory.getSubDirectories().remove(dirName);
                journal.logOperation("Apagando Diretório: "+ dirName);
                break;
            case "mkfile":
                String fileName = parts[1];
                File newFile = new File(fileName);
                currentDirectory.getFiles().put(fileName, newFile);
                journal.logOperation("Criando Arquivo: "+ fileName);
                break;
            case "rmfile":
                fileName = parts[1];
                currentDirectory.getFiles().remove(fileName);
                journal.logOperation("Apagando Arquivo: "+ fileName);
                break;
            case "rename":
                String oldName = parts[1];
                String newName = parts[2];
                if (currentDirectory.getFiles().containsKey(oldName)) {
                    File file = currentDirectory.getFiles().get(oldName);
                    file.setName(newName);
                    currentDirectory.getFiles().remove(oldName);
                    currentDirectory.getFiles().put(newName, file);
                    journal.logOperation("Renomeando Arquivo de: "+ oldName + "Para" + newName);
                } else if (currentDirectory.getSubDirectories().containsKey(oldName)) {
                    Directory dir = currentDirectory.getSubDirectories().get(oldName);
                    currentDirectory.getSubDirectories().remove(oldName);
                    currentDirectory.getSubDirectories().put(newName, dir);
                    journal.logOperation("Renomeando Diretório de: "+ oldName + "Para" + newName);
                }
                break;
            case "ls":
                System.out.println("Diretórios:");
                for (String d : currentDirectory.getSubDirectories().keySet()) {
                    System.out.println(" - " + d);
                }
                System.out.println("Arquivos:");
                for (String f : currentDirectory.getFiles().keySet()) {
                    System.out.println(" - " + f);
                }
                break;
            case "cd":
                dirName = parts[1];
                if (dirName.equals("..")) {
                    if (currentDirectory.getParent() != null) {
                        setCurrentDirectory(currentDirectory.getParent());
                    }
                } else if (currentDirectory.getSubDirectories().containsKey(dirName)) {
                    setCurrentDirectory(currentDirectory.getSubDirectories().get(dirName));
                } else {
                    System.out.println("Diretório não encontrado.");
                }
                break;
            case "info":
                System.out.println("-- Lista de comandos --");
                System.out.println(" mkdir: Cria diretório \n rmdir: Apaga Diretório \n mkfile: Cria arquivo \n" +
                        " rmfile: Remove arquivo \n rename: Renomeia o arquivo \n ls: lista os dados \n cd: entra no diretório \n cd..: sai do diretório");
                break;
            default:
                System.out.println("Comando não reconhecido.");
        }
    }

    private void updateCurrentPath() {
        StringBuilder path = new StringBuilder();
        Directory dir = currentDirectory;
        while (dir != null) {
            path.insert(0, dir.getName());
            if (!dir.getName().equals("/")) {
                path.insert(0, "/");
            }
            dir = dir.getParent();
        }
        currentPath = path.toString();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void recoverFromJournal() {
        for (String entry : journal.getEntries()) {
            executeOperation(entry);
        }
    }
}
