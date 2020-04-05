package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = "D:/IdeaProjects/E- Commerce Test Automaton Framework/src/main/java/com/qa/config/Environment.properties";
    private static String url;
    private static String driverPath;


    //Create a Singleton instance
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        Properties props = new Properties();

        try {
            FileInputStream fileInput = new FileInputStream(propertyFilePath);
            props.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Get properties from Environment.properties
        url = props.getProperty("url");
        driverPath = props.getProperty("driverPath");

    }
    public String getUrl ()
    {
        return url;
    }
    public String getDriverPath () {
        return driverPath;
    }


}
