package org.games.service;

import org.games.domains.Settings;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {
    private static final String FILE_DIR = System.getProperty("user.dir") + "/src/main/resources/saves/settings.set";

    public void save(Settings settings) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_DIR));
            oos.writeObject(settings);
            oos.close();
        } catch (Exception e) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Settings load() {
        Settings settings = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_DIR));
            Settings savedSettings = (Settings) ois.readObject();
            if (savedSettings != null) {
                settings = savedSettings;
            }
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return settings;
    }
}
