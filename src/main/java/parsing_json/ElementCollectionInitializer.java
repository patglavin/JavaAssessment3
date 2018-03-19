package parsing_json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Collections;

public class ElementCollectionInitializer {

    public static ElementCollection generate() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(loadFile()));
        ElementCollection elementCollection = new ElementCollection();
        Gson gson = new GsonBuilder().create();
        Element[] elements = gson.fromJson(br, Element[].class);
        Collections.addAll(elementCollection, elements);
        return elementCollection;
    }

    private static File loadFile(){
        ClassLoader classLoader = ElementCollectionInitializer.class.getClassLoader();
        return new File(classLoader.getResource("periodic_table.json").getFile());
    }
}
