/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b12x;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kaeaton
 */
public class LocusNameParser {
    public LocusNameParser ()
    {

    }
    
    public static String parseLocus(String locus)
    {
        String parsedLocus = "";
        Pattern p = Pattern.compile("^HLA-(\\w+)$");
        Matcher m = p.matcher(locus);
            
        // Find locus
        if (m.find()) 
        {
            parsedLocus = m.group(1);
            System.out.println(parsedLocus);
        }
        
        return parsedLocus;
    }
    
    public static String hlaOrKir(String locus)
    {
        String type = "";
        Pattern p = Pattern.compile("^([A-Z]{3})");
        Matcher m = p.matcher(locus);

        // Find locus
        if (m.find()) {
            type = m.group(1);
            System.out.println(type);
        }
        
        return type;
    }
}
