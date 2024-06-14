import java.util.HashMap;
import java.util.Map;

public class Directory {
    private String name;
    private Directory parent;
    private Map<String, Directory> subDirectories;
    private Map<String, File> files;

    public Directory(String name) {
        this(name, null);
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.subDirectories = new HashMap<>();
        this.files = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public Map<String, Directory> getSubDirectories() {
        return subDirectories;
    }

    public Map<String, File> getFiles() {
        return files;
    }
}
