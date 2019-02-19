import com.at.avro.AvroSchema;
import com.at.avro.DbSchemaExtractor;
import com.at.avro.SchemaGenerator;
import com.at.avro.config.AvroConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main (String [ ] args) {

        ObjectMapper mapper = new ObjectMapper();
        Structure s = new Structure();
        try {
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(s);
            System.out.println(jsonInString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //empezar();


    }

    public static void empezar(){
        ObjectMapper mapper = new ObjectMapper();
        AvroMapper avMapper = new AvroMapper();

        // Initialize db crawler that will create avro model objects
        DbSchemaExtractor schemaExtractor = new DbSchemaExtractor("jdbc:mysql://10.45.17.59:3306/test_avro", "root", "HayaiEsLaP0ya.");

        AvroConfig avroConfig = new AvroConfig("some.namespace");
        // Get avro models for a few tables
        List<AvroSchema> schemas = schemaExtractor.getForTables(avroConfig, "test_avro", "accesorios","altas");

        for (AvroSchema schema : schemas) {
            // Pass avro model to SchemaGenerator, get schema and print it out.
            String schemaJson = SchemaGenerator.generate(schema);
            System.out.println(schemaJson);
            //formatter(mapper,schemaJson);
        }
    }

    public static void formatter(ObjectMapper mapper, String json){
        try {

            JsonNode node = mapper.readTree(json);
            mapper.writeValue(new File("target/salida.json"), node);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
