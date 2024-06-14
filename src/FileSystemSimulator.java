public class FileSystemSimulator {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.recoverFromJournal(); // Recuperar do journal
        FileSystemShell shell = new FileSystemShell(fileSystem);
        shell.run();
    }
}
