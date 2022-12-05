package Lab_8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordSort {
   public static void main(String[] args) throws IOException {
       if (args.length < 2) {
            System.out.println("Usage: WordSort input_file output_file");
            return;
       }
       String inputFile = args[0];
       String outputFile = args[1];

       /*
        * Create the word map. Each key is a word and each value is an
        * Integer that represents the number of times the word occurs
        * in the input file.
        */
        Map<String, Integer> map = new TreeMap<String, Integer>();

        Scanner scanner = new Scanner( new File(inputFile) );
        while ( scanner.hasNext() ) {
            String word = scanner.next();
            Integer count = map.get( word );
            count = ( count == null  ? 1 : count + 1 );
            map.put( word, count ); 
        }
        scanner.close();

        // get the map's keys
        List<String> keys = new ArrayList<String>(map.keySet());

        // write the results to the output file
        PrintWriter out = new PrintWriter( new FileWriter(outputFile) );
        for (String key : keys) {
            out.println( key + " : " + map.get(key) );
        }
        out.close();
   }
}
