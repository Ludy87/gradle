package {applicationId};

/**
 * Class holding configuration variables for our applications
 *
 * @author Vincent Prat @ MarvinLabs
 */
public class Configuration {

    public static final String PACKAGE_NAME = "{unlock}";

    // TODO RELEASE CHECK This should be set to false
    public static final boolean DEBUG_ENABLED = true;

    // Enable to allow all features in the debug application
    public static final boolean DEBUG_AUTHORIZE_ALL_FEATURES;

    // A feature ID (used to test feature-level authorization)
    public static final String MY_LOCKED_FEATURE = "MyLockedFeature";
    public static final String MY_LOCKED_FEATURE_TEST = "TEST";

    // Code to initialize the variables differently in debug/release mode
    static {
        if (DEBUG_ENABLED) {
            DEBUG_AUTHORIZE_ALL_FEATURES = true;
        } else {
            DEBUG_AUTHORIZE_ALL_FEATURES = false;
        }
    }
}
