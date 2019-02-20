import java.util.ArrayList;
import java.util.List;

public class Table {
    private String tableName = null ;
    private List<pkFieldName> pkFieldNames = new ArrayList<pkFieldName>();
    private List<Fk> Fks = new ArrayList<Fk>();
    private List<Parent> Parents = new ArrayList<Parent>();
    private List<Field> Fields = new ArrayList<Field>();


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<pkFieldName> getPkFieldNames() {
        return pkFieldNames;
    }

    public void setPkFieldNames(List<pkFieldName> pkFieldNames) {
        this.pkFieldNames = pkFieldNames;
    }

    public List<Fk> getFks() {
        return Fks;
    }

    public void setFks(List<Fk> fks) {
        Fks = fks;
    }

    public List<Parent> getParents() {
        return Parents;
    }

    public void setParents(List<Parent> parents) {
        Parents = parents;
    }

    public List<Field> getFields() {
        return Fields;
    }

    public void setFields(List<Field> fields) {
        Fields = fields;
    }
}
