/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author katrinaeaton
 */
public class GlobalVariables {
    private static String neo4jURL = new String("http://neo4j.b12x.org/db/data/transaction/commit");
//    private static String neo4jURL = new String("http://3.216.70.20/db/data/transaction/commit");
    private static String dataFilesPath = new String(System.getProperty("user.home") 
                + System.getProperty("file.separator") + "Documents" 
                + System.getProperty("file.separator") + "BSG"
                + System.getProperty("file.separator") + "BSGData"
                + System.getProperty("file.separator") );
//                + "neo4j_version.txt");
    private static String resultsFilesPath = new String(System.getProperty("user.home") 
                + System.getProperty("file.separator") + "Documents" 
                + System.getProperty("file.separator") + "BSG"
                + System.getProperty("file.separator") );
    private static JsonFactory factory = new JsonFactory();
    
    public GlobalVariables () {
        
    }
    
    // getter methods for the few things that need a central repository
    
    // the fewer factories running, the less memory needed
    public static JsonFactory factory () {
        return factory;
    }
    
    // url for data queries from neo4j.b12x.org
    public static String neo4jUrl () throws IOException {
        return neo4jURL;
    }
    
    // the location of BSG's raw data files
    public static String dataFilesPath () {
        return dataFilesPath;
    }
    
    // the default location of the saved results file
    public static String resultsFilesPath () {
        return resultsFilesPath;
    }    
}
