package {applicationId};

import android.content.ContentResolver;

import org.astra_g.freepro_lib.AuthorizationContentProvider;
import org.astra_g.freepro_lib.AuthorizationPolicy;
import org.astra_g.freepro_lib.policy.AuthorizeFeaturesPolicy;
import org.astra_g.freepro_lib.policy.AuthorizePackagePolicy;
import org.astra_g.freepro_lib.policy.AuthorizeTest;


/**
 * Sample content provider to authorize the locked sample application.
 * <p>
 * This content provider currently provides a function to globally test the
 * presence of an unlock application for our package and a function that allows
 * to see if the unlock application installed allows to use a given feature.
 * This content provider is configured to allow only the feature defined by
 * {@link Configuration#MY_LOCKED_FEATURE}.
 *
 * @author Vincent Prat @ MarvinLabs
 */
public class UnlockerProvider extends AuthorizationContentProvider {

    // The policy used by the content provider to authorize at the package level
    private static final AuthorizationPolicy PACKAGE_LEVEL_POLICY = AuthorizePackagePolicy
            .newInstance(Configuration.PACKAGE_NAME, Configuration.PACKAGE_NAME);

    // The policy used by the content provider to authorize at the feature level
    private static final AuthorizationPolicy FEATURE_LEVEL_POLICY = AuthorizeFeaturesPolicy
            .newInstanceForAuthorization(Configuration.PACKAGE_NAME,
                    Configuration.PACKAGE_NAME,
                    new String[]{Configuration.MY_LOCKED_FEATURE});

    private static final AuthorizationPolicy FEATURE_TEST_LEVEL_POLICY = AuthorizeTest
            .newInstanceForAuthorization(Configuration.PACKAGE_NAME,
                    Configuration.PACKAGE_NAME,
                    new String[]{Configuration.MY_LOCKED_FEATURE_TEST});

    /**
     * Constructor
     */
    public UnlockerProvider() {
        super(Configuration.PACKAGE_NAME);
        setOutputDebugInformation(Configuration.DEBUG_ENABLED);
        addAuthorizationPolicy(PACKAGE_LEVEL_POLICY);
        addAuthorizationPolicy(FEATURE_LEVEL_POLICY);
        addAuthorizationPolicy(FEATURE_TEST_LEVEL_POLICY);
    }

    /**
     * Call this function to know if the unlocker is installed for our package
     *
     * @param cr The content resolver you get from the context
     * @return true if the unlock application is installed for our package
     */
    public static boolean getPackageLevelAuthorization(ContentResolver cr) {
        return getAuthorization(cr, AuthorizePackagePolicy.newInstance(
                Configuration.PACKAGE_NAME, Configuration.PACKAGE_NAME));
    }

    /**
     * Call this function to know if the unlocker installed for our package
     * authorizes the given feature
     *
     * @param cr             The content resolver you get from the context
     * @param queriedFeature The feature that needs to be authorized
     * @return true if the unlock application is installed for our package and
     * it authorizes the given feature
     */
    public static boolean getFeatureLevelAuthorization(ContentResolver cr,
                                                       String queriedFeature) {
        return getAuthorization(cr,
                AuthorizeFeaturesPolicy.newInstanceForQuery(
                        Configuration.PACKAGE_NAME, Configuration.PACKAGE_NAME,
                        queriedFeature));
    }

    public static boolean getTestLevelAuthorization(ContentResolver cr,
                                                    String queriedFeature) {
        return getAuthorization(cr,
                AuthorizeTest.newInstanceForQuery(
                        Configuration.PACKAGE_NAME, Configuration.PACKAGE_NAME,
                        queriedFeature));
    }
}
