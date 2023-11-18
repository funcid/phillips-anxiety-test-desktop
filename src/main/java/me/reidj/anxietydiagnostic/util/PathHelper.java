package me.reidj.anxietydiagnostic.util;

import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.net.URL;

@UtilityClass
public class PathHelper {

    public URL getResource(String path){
        if (PathHelper.class.getResource(path) == null) {
            try {
                throw new FileNotFoundException(String.format("File %s not found", path));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return PathHelper.class.getResource(path);
    }
}
