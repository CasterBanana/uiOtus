package utils.resources;

import java.io.FileNotFoundException;
import java.util.Map;

public interface IResource {
    Map<String,String> read() throws FileNotFoundException;
}
