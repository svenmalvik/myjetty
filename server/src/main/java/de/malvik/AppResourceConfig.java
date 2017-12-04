package de.malvik;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by smalvik on 04.12.2017.
 */
public class AppResourceConfig extends Application {
    private Set<Class<?>> classesSet = new HashSet<Class<?>>();

    public AppResourceConfig() {
        classesSet.add(Endpoint2.class);
    }

    public Set<Class<?>> getClasses() {
        return (classesSet);
    }
}
