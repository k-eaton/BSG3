
package neo4j;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.util.Hashmap;
import java.util.*;

/**
 *
 * @author katrinaeaton
 */
public class Neo4jParser {
    
    public Neo4jParser() {

    }
    
    public void parseResponse(InputStream httpResult, JsonFactory factory) throws IOException {
        try {
            
            // Write raw data to file
//            ObjectMapper mapper = new ObjectMapper();
            File neo4jParsed = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Documents" + System.getProperty("file.separator") + "neo4jParsedData.json");
            Map neo4jPairs = new HashMap();
//            Object json = mapper.readValue(httpResult, Object.class);
//            File neo4jRaw = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Documents" + System.getProperty("file.separator") + "neo4jRawData.json");
//            mapper.writerWithDefaultPrettyPrinter().writeValue(neo4jRaw, json);  
            
            JsonParser parser = factory.createParser(httpResult);
            
            // continue parsing the token till the end of input is reached
            while (!parser.isClosed()) {
                // get the token
                JsonToken token = parser.nextToken();
                // if its the last token then we are done
                if (token == null)
                    break;
                // we want to look for a field that says data

                if (JsonToken.FIELD_NAME.equals(token) && "data".equals(parser.getCurrentName())) {
                    // we are entering the datasets now. The first token should be
                    // start of array
                    token = parser.nextToken();

                    // we are now looking for a field that says "row". We
                    // continue looking till we find all such fields. This is
                    // probably not a best way to parse this json, but this will
                    // suffice for this example.
                    while (true) {
                        token = parser.nextToken();
                        if (token == null)
                                break;
                        if (JsonToken.FIELD_NAME.equals(token) && "row".equals(parser.getCurrentName())) {
                            token = parser.nextToken();
                            token = parser.nextToken();
                            String key = parser.getText();
                            System.out.println(parser.getText());
//                            System.out.println(parser.nextFieldName());

                            token = parser.nextToken();
                            String value = parser.getText();
                            System.out.println(parser.getText());
                            neo4jPairs.put(key, value);
                            
//                            mapper.writeValue(neo4jParsed, token);
                        }
                    }
                }
            }
//            System.out.println(neo4jPairs);
            parser.close();
            
        
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}