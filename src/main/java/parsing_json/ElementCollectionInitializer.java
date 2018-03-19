package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class ElementCollectionInitializer {

    private static File file = new File("/Users/patrickglavin/Dev/fourth_hex/fourthAssessment/src/main/resources/periodic_table.json");

    public static ElementCollection generate() throws FileNotFoundException {
        InputStream inputStream = ElementCollectionInitializer.class.getClassLoader().getResourceAsStream("periodic_table.json");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("json.filepath"));
        BufferedReader br = new BufferedReader(loadFile());
        ElementCollection elementCollection = new ElementCollection();
        Gson gson = new GsonBuilder().create();
        Element[] elements = gson.fromJson(br, Element[].class);
        for (Element element:elements) {
            elementCollection.add(element);
        }
        return elementCollection;
    }

    private static String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }
}
