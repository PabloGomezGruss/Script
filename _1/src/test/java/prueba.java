import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.annotate.JsonMethod;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class prueba {

    @Test
    public void pruebaScript() throws JsonProcessingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Structure obj = new Structure();
        iniciar(obj);
        DefaultPrettyPrinter pp = new DefaultPrettyPrinter();
        pp.indentArraysWith(new DefaultPrettyPrinter.Lf2SpacesIndenter());
        String jsonInString = mapper.writer(pp).writeValueAsString(obj);
        System.out.println(jsonInString);

        //assertThat();
    }

    public void iniciar(Structure obj){
        Field f = new Field();
        Field f2 = new Field();
        ArrayList<Field> array = new ArrayList();
        array.add(f);
        array.add(f2);


        Table tab = new Table();
        ArrayList<Table> array2 = new ArrayList();
        array2.add(tab);

        tab.setFields(array);
        obj.setTables(array2);


    }
}
