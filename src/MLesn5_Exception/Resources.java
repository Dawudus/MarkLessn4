package MLesn5_Exception;

/**
 * Created by dustu on 24.05.2016.
 */
public class Resources implements AutoCloseable{
    private String resource="none";

    public Resources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public void close() throws Exception {
        this.resource="none";
        System.err.println(toString());
    }

    @Override
    public String toString() {
        return "Resources{" +
                "resource='" + resource + '\'' +
                '}';
    }
}
