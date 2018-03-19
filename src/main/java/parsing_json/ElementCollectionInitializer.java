package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ElementCollectionInitializer {

    private static File file = new File("/Users/patrickglavin/Dev/fourth_hex/fourthAssessment/src/main/resources/periodic_table.json");

    public static ElementCollection generate() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ElementCollection elementCollection = new ElementCollection();
        Gson gson = new GsonBuilder().create();
        Element[] elements = gson.fromJson(br, Element[].class);
        for (Element element:elements) {
            elementCollection.add(element);
        }
        return elementCollection;
    }
}
