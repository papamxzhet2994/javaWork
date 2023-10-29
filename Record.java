public class Record {
    private int id;
    private String data;

    public Record(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String newData) {
        this.data = newData;
    }
}
