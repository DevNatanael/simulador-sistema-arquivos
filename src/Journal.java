import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> entries;
    private static final String JOURNAL_FILE = "journal.log";

    public Journal() {
        entries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getEntries() {
        return entries;
    }

    public void clear() {
        entries.clear();
    }

    public void logOperation(String operation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE, true))) {
            writer.write(operation);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar journal: " + e.getMessage());
        }
    }
}
