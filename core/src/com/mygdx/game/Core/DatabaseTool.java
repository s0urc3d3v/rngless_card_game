package com.mygdx.game.Core;

import java.io.*;
import java.util.*;

/**
 * Created by s0urc3d3v3l0pm3nt on 1/20/2016.
 */
public class DatabaseTool {
    static LinkedHashMap<String, Boolean> prefs = new LinkedHashMap<>();
    private static String fileName = "";
    private static BufferedReader reader;
    private static BufferedWriter writer;
    public static void init(){
        fileName = System.getProperty("user.dir") + File.separator + "data" + File.separator + "settings.txt";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            reader.mark(0);
            writer = new BufferedWriter(new FileWriter(fileName));

            updatePreferencesFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rebuilds the database file from scratch.  A very resource intensive operation.  If possible instead use the addNewPreferencesToFile() method
     *
     * @throws IOException is thrown to handle the following calls to the methods of the BufferedWriter(FileWriter()) object: .write(), .append(), .close()
     */
    public static void recreateFileDatabase() throws IOException{
        writer.write("");
        for (Map.Entry<String, Boolean> x : prefs.entrySet())
            writer.append(x.getKey()).append(":").append(String.valueOf(x.getValue()));
        writer.close();
    }

    /**
     * Parses the database file and updates the LinkedHashMap object to contain the new key pairs in the file that are not yet contained by the LinkedHashMapObject.
     * This can be useful if you manually add entries however bear in mind that arbintrary spaces in the database file will cause problems.
     *
     * @throws IOException This method handles the repeated calls to BufferedReader(FIleReader()).readLine() by throwing an IOException
     *
     */
    public static void updatePreferencesFromFile() throws IOException {
        boolean shouldContinue = true;
        String line = "";
        while (shouldContinue){
            line = reader.readLine();
            if (line == null)
                shouldContinue = false;
            else
                for (int i = 0; i < line.length(); i++)
                    if (line.charAt(i) == ':')
                        if (!prefs.get(line.substring(0, i - 1)).equals(Boolean.valueOf(line.substring(i + 1))) && prefs.get(line.substring(0, i - 1)) != null)
                            prefs.replace(line.substring(0, i - 1), Boolean.valueOf(line.substring(i + 1)));
                        else prefs.put(line.substring(0, i - 1), Boolean.valueOf(line.substring(i + 1)));
        }
    }

    /**
     * Adds a new key pair to the LinkedHashMap.
     *
     * @param preference (String) The name of the preference you are adding to the LinkedHashMap
     * @param status (boolean) The boolean condition of the preference argument
     */
    public static void addPreference(String preference, boolean status) {
        prefs.put(preference, status);

    }

    /**
     * Takes the input List of map entries and appends them to the LinkedHashMap instance feild
     *
     * @param pairs (List<Map.Entry<String, Boolean>>) A List of map entries to be added to the LinkedHashMap instance field
     */
    public static void addArrayOfKeyPairsToMap(List<Map.Entry<String, Boolean>> pairs){
        for (Map.Entry<String, Boolean> pair : pairs) prefs.put(pair.getKey(), pair.getValue());
    }

    /**
     * Returns the preference associated with the input key
     *
     * @param key (String) The preference used to find the value associated with it
     *
     * @return (boolean) The value referenced by the "key" argument in the LinkedHashMap instance field
     */
    public static Boolean getPreference(String key){
        return prefs.get(key);
    }

    /**
     * Compares the number of key pairs in the LinkedHashMap instance field with the number of key pairs in the database file
     * and adds the new key pairs in the LinkedHashMap to the file.
     *
     * NOTE: It compares the number of arguments which means that
     * if the last key pairs in the LinkedHashMap are not the newest they cause the program to behave in an undesirable manner.  TO prevent this
     * do not rearrange the elements in the LinkedHashMap
     *
     * @throws IOException Throws an IOException to handle looped calls to the BufferedReader(FileReader()).readLine() in the call to the getLineCountInDB() method.
     */
    public static void addNewPreferencesToFile() throws IOException {
        int finalPairInFile = getLineCountInDB();
        int mapSize = prefs.size();
        String key = "";

        if( finalPairInFile < mapSize) // may cause problems as size does not need to change to be a change present
            for (int i = finalPairInFile; i < mapSize; i++) {
                key = getKeyWithIndexFromMap(i);
                appendKeyPairToFile(key, prefs.get(key));
            }
    }

    /**
     * Gets the number of populated lines in the database file.
     *
     * @return (int) Number of populated lines in the database file.
     * @throws IOException Throws IOException to handle looped calls to BufferedReader(FileReader()).readLine()
     */
    public static int getLineCountInDB() throws IOException{
        int count = 0;
        reader.reset();
        while (reader.readLine() != null) count++;
        return count;
    }

    /**
     * Returns the key at the index passed as the argument in the LinkedHashMap instance field.
     * @param index (int) The index of the key that is returned.
     * @return (String) The key at the index passed as the argument.
     */
    public static String getKeyWithIndexFromMap(int index){
        return (String) prefs.keySet().toArray()[index];
    }

    public static boolean getValueWithIndexFromMap(int index){
        return (boolean) prefs.values().toArray()[index];
    }

    /**
     * Appends a key pair to the database file.
     *
     * @param key (String) The key used to access the value associated with it in the database.
     * @param value (boolean) The value associated with the key passed as the first argument.
     * @throws IOException Throws an IOException to handle chained calls to BufferedWriter(FileWriter)).append()
     */
    public static void appendKeyPairToFile(String key, boolean value) throws IOException {
        writer.append(key).append(":").append(String.valueOf(value));
    }
    public static void updatePref(String prefName, boolean value){
        prefs.put(prefName, value);
    }



}