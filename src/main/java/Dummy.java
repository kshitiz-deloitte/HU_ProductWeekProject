import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Dummy {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        System.out.println(prop.getProperty("login_admin_username"));
        String[] a = prop.getProperty("login_user_roles").split(",");
        for (String i: a){
            System.out.println(i);
        }
    }
}
