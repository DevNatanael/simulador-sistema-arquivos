
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JournalManager {
    private static final String JOURNAL_FILE = "journal.log";

    public void logOperation(String operation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE, true))) {
            writer.write(operation);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar journal: " + e.getMessage());
        }
    }
}
