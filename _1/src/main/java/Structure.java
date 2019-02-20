import com.at.avro.AvroSchema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Structure implements Serializable {

    private String packageRoot = "com.everis.hayai.ahiMas.correlationEngine.model";
    private String imports = "com.everis.hayai.stagging.{CompanionDTO, DTO, StaggingEngine}";
    private String finalDB = "ahimasmf";
    private String topicPrefix = "hayai.hayai.";
    private String inputTopicSuffix = "correlation";
    private List<Table> Tables = new ArrayList<Table>();


    public String getPackageRoot() {
        return packageRoot;
    }

    public void setPackageRoot(String packageRoot) {
        this.packageRoot = packageRoot;
    }

    public String getImports() {
        return imports;
    }

    public void setImports(String imports) {
        this.imports = imports;
    }

    public String getFinalDB() {
        return finalDB;
    }

    public void setFinalDB(String finalDB) {
        this.finalDB = finalDB;
    }

    public String getTopicPrefix() {
        return topicPrefix;
    }

    public void setTopicPrefix(String topicPrefix) {
        this.topicPrefix = topicPrefix;
    }

    public String getInputTopicSuffix() {
        return inputTopicSuffix;
    }

    public void setInputTopicSuffix(String inputTopicSuffix) {
        this.inputTopicSuffix = inputTopicSuffix;
    }

    public List<Table> getTables() {
        return Tables;
    }

    public void setTables(List<Table> Tables) {
        this.Tables = Tables;
    }

    public void newTable(Table tabla) {
        this.Tables.add(tabla);
    }
}
