import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class RegistrationConstants {

    private static final Config config = ConfigFactory.load();
    public static final String LOCATION_OF_CHROMEDRIVER = config.getString("location.of.chrome.driver");
}
