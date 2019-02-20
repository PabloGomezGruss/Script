import com.at.avro.AvroField;
import com.at.avro.AvroSchema;
import com.at.avro.AvroType;
import com.at.avro.DbSchemaExtractor;
import com.at.avro.config.AvroConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main (String [ ] args) {

        Main m = new Main();
        m.empezar();


    }

    public void empezar(){
        ObjectMapper mapper = new ObjectMapper();
        Structure struct = new Structure();
        List<Table> tablas = new ArrayList<Table>();

        // Initialize db crawler that will create avro model objects
        DbSchemaExtractor schemaExtractor = new DbSchemaExtractor("jdbc:mysql://10.45.17.59:3306/test_avro", "root", "HayaiEsLaP0ya.");

        AvroConfig avroConfig = new AvroConfig("some.namespace");
        // Get avro models for a few tables
        List<AvroSchema> schemas = schemaExtractor.getForTables(avroConfig, "test_avro", "accesorios","altas");

        for (AvroSchema schema : schemas) {
            //Pass avro model to SchemaGenerator, get schema and print it out.
            //String schemaJson = SchemaGenerator.generate(schema);
            //System.out.println(schemaJson);
            //formatter(mapper,schemaJson);
            Table tabla = new Table();
            llenar_tabla(tabla,schema);
            tablas.add(tabla);
        }

        struct.setTables(tablas);
        try {
            DefaultPrettyPrinter pp = new DefaultPrettyPrinter();
            pp.indentArraysWith(new DefaultPrettyPrinter.Lf2SpacesIndenter());
            String jsonInString = mapper.writer(pp).writeValueAsString(struct);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public void llenar_tabla(Table tabla, AvroSchema schema){

        tabla.setTableName(schema.getName());
        List<Field> fields = new ArrayList<Field>();
        for(AvroField field : schema.getFields()) {
            Field f = new Field();
            f.setFieldname(field.getName());
            f.setType(introducir_type(field.getType()));
            fields.add(f);

        }

        tabla.setFields(fields);

    }

    public String introducir_type(AvroType type){

        String tipo = type.getType().getPrimitiveType();

        if(tipo.equals("double") || tipo.equals("int")) tipo = "Integer";
        else if(tipo.equals("string") || tipo.equals("boolean")) tipo = "String";

        if(type.isNullable()){
            return "Option[" + tipo + "]";
        }
        else return tipo;

    }


}
