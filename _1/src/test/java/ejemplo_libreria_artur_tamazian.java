import com.at.avro.AvroSchema;
import com.at.avro.DbSchemaExtractor;
import com.at.avro.SchemaGenerator;
import com.at.avro.config.AvroConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ejemplo_libreria_artur_tamazian {

    @Test
    public void ejemplo(){

        // Initialize db crawler that will create avro model objects
        DbSchemaExtractor schemaExtractor = new DbSchemaExtractor("jdbc:mysql://10.45.17.59:3306/test_avro", "root", "HayaiEsLaP0ya.");

        AvroConfig avroConfig = new AvroConfig("some.namespace");
        // Get avro models for a few tables
        List<AvroSchema> schemas = schemaExtractor.getForTables(avroConfig, "test_avro", "clientes_maestro_raw","internet_raw");

        for (AvroSchema schema : schemas) {
            // Pass avro model to SchemaGenerator, get schema and print it out.
            String schemaJson = SchemaGenerator.generate(schema);
            System.out.println(schemaJson);
        }
    }
}
