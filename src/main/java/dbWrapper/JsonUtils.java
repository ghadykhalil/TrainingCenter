package dbWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JsonUtils {

    private static JsonUtils instance;
    private final ObjectMapper mapper = new ObjectMapper();

    // Private constructor to prevent direct instantiation
    private JsonUtils() {}

    // Public method to provide access to the singleton instance
    public static synchronized JsonUtils getInstance() {
        if (instance == null) {
            instance = new JsonUtils();
        }
        return instance;
    }

    private String getAbsolutePath(String filePath) {
        return Paths.get("").toAbsolutePath().toString() + File.separator + filePath;
    }

    public <T> List<T> readData(String filePath, Class<T> clazz) throws IOException {
        File file = new File(getAbsolutePath(filePath));
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
    }

    public <T> void writeData(String filePath, List<T> data) throws IOException {
        mapper.writeValue(new File(getAbsolutePath(filePath)), data);
    }

    public <T> void saveData(String filePath, T item) throws IOException {
        List<T> data = readData(filePath, (Class<T>) item.getClass());
        data.add(item);
        writeData(filePath, data);
    }

    public <T> void updateData(String filePath, T updatedItem, Predicate<T> predicate) throws IOException {
        List<T> data = readData(filePath, (Class<T>) updatedItem.getClass());
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);
            if (predicate.test(item)) {
                data.set(i, updatedItem);
                break;
            }
        }
        writeData(filePath, data);
    }

    public <T> void deleteData(String filePath, Predicate<T> predicate) throws IOException {
        List<T> data = readData(filePath, null);
        data.removeIf(predicate::test);
        writeData(filePath, data);
    }
}
