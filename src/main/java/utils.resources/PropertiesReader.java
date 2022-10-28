package utils.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


public class PropertiesReader implements IResource{
    @Override
    public Map<String, String> read() throws FileNotFoundException {
        String rootFolder = System.getProperty("user.dir"); // системная настройка, которая хранит путь к проекту
//        Map<String, String> props = new HashMap<>();

        try (InputStream input = new FileInputStream(String.format("%s/src/test/resources/%s", rootFolder, "properties"))) { // InputStream для того, чтобы прочитать файл db.properties
            Properties prop = new Properties();// объект properties
            prop.load(input);
            return prop.entrySet().stream().collect(
                    Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue().toString()
                    )
            );



//            for(Object key: prop.entrySet()) {// бегаем по ключам prop, set - список, который хранит объекты, не может содержать два одинаковых объекта
//
//                props.put((String)key, prop.getProperty((String)key));
//            }
//            return props;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
