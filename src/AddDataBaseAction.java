public class AddDataBaseAction extends DataBaseAction{
    private final DataRow dataRow;
    AddDataBaseAction(DataRow dataRow){
        this.dataRow = dataRow;
    }
    @Override
    public String execute() {
        return "insert into test(info) value (\""+dataRow.getText()+"\");";
    }
}
