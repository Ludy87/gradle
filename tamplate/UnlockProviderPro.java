package {applicationId};

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
public class UnlockProvider extends AuthorizationContentProvider {

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
    public UnlockProvider() {
        super(Configuration.PACKAGE_NAME);
        setOutputDebugInformation(Configuration.DEBUG_ENABLED);
        addAuthorizationPolicy(PACKAGE_LEVEL_POLICY);
        addAuthorizationPolicy(FEATURE_LEVEL_POLICY);
        addAuthorizationPolicy(FEATURE_TEST_LEVEL_POLICY);
    }
}
