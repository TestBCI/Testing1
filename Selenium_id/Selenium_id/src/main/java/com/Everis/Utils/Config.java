package com.Everis.Utils;

import java.io.FileInputStream;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Config {
	
	private static final ResourceBundle RESOURCEBUNDLEMSG = getResurceBundleFromFile("src/main/java/config.properties");
	
	private Config() {
    }
	
	public static String getString(String key) {
        try {
            return RESOURCEBUNDLEMSG.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
	
	public static ResourceBundle getResurceBundleFromFile(String file) {
		ResourceBundle resource = null;
		FileInputStream fis = null;
		try {
            fis = new FileInputStream(file);
            resource = new PropertyResourceBundle(fis);
            fis.close();
        } catch (Exception ex) {
        	throw new Error("Problemas al leer el archivo de properties: " + ex);
        }
		return resource;
	}
}
