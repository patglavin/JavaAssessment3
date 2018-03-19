package user_management;

import java.io.File;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;

public class UserCollectionInitializer {
    private static File file = new File("/Users/patrickglavin/Dev/fourth_hex/fourthAssessment/src/main/resources/users.json");

    public static UserCollection generate() throws FileNotFoundException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        UserCollection userCollection = new UserCollection();
        Gson gson = new GsonBuilder().create();
        User[] users = gson.fromJson(br, User[].class);
        Collections.addAll(userCollection, users);
        return userCollection;
    }
}
