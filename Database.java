import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Record> records;
    private int nextId;

    public Database() {
        records = new ArrayList<>();
        nextId = 1;
    }

    public void insertRecord(String data) {
        records.add(new Record(nextId, data));
        nextId++;
    }

    public void updateRecord(int id, String newData) {
        for (Record record : records) {
            if (record.getId() == id) {
                record.setData(newData);
                break;
            }
        }
    }

    public void moveRecord(int sourceIndex, int destinationIndex) {
        if (sourceIndex >= 0 && sourceIndex < records.size() &&
                destinationIndex >= 0 && destinationIndex < records.size()) {
            Record record = records.remove(sourceIndex);
            records.add(destinationIndex, record);
        }
    }

    public void deleteRecord(int id) {
        records.removeIf(record -> record.getId() == id);
    }

    public List<Record> getRecords() {
        return records;
    }
}