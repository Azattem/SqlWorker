public class DataRow {
    private int id = 0;
    private final String text;
    public DataRow(int id,String string){
        this.id = id;
        text = string;
    }
    public DataRow(String string){
        text = string;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return id+" "+text;
    }
}
