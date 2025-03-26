package com.gradle;

import com.gradle.develocity.agent.gradle.adapters.BuildCacheConfigurationAdapter;
import com.gradle.develocity.agent.gradle.adapters.BuildScanAdapter;
import com.gradle.develocity.agent.gradle.adapters.DevelocityAdapter;

/**
 * Provide standardized Develocity configuration.
 * By applying the plugin, these settings will automatically be applied.
 */
final class CustomDevelocityConfig {

    void configureDevelocity(DevelocityAdapter develocity) {
        /* Example of Develocity configuration

        develocity.setServer("https://ge-helm-standalone-unstable-release.grdev.net");
        develocity.setAllowUntrustedServer(true);
        develocity.setProjectId("ccud-injection");

        develocity.setServer("https://enterprise-samples.gradle.com");
        develocity.setAllowUntrustedServer(false);

        */
    }

    void configureBuildScanPublishing(BuildScanAdapter buildScan) {
        /* Example of build scan publishing configuration

        buildScan.publishOnFailure();

        buildScan.tag("CCUD_TESTING");
        buildScan.link("LINK", "https://github.com/gradle/actions");
        buildScan.value("CUSTOM_VALUE", "THE VALUE");

        buildScan.setUploadInBackground(false);

        buildScan.capture(capture -> {
            capture.setFileFingerprints(false);
            capture.setBuildLogging(false);
            capture.setTestLogging(false);
        });

        BuildScanObfuscationAdapter obfuscationAdapter = buildScan.getObfuscation();
        if (obfuscationAdapter != null) {
            obfuscationAdapter.hostname(s -> "FIXED-HOSTNAME");
        }

        buildScan.obfuscation(obfuscation -> {
            obfuscation.username(s -> "FIXED-USERNAME");
        });

        buildScan.background(adapter -> {
            adapter.tag("BACKGROUND_TAG");
        });

        buildScan.buildFinished(adapter -> {
            buildScan.tag("BUILD_FINISHED_TAG");
        });

        boolean isCiServer = System.getenv().containsKey("CI");

        buildScan.publishAlways();
        buildScan.capture(capture -> capture.setTaskInputFiles(true));
        buildScan.setUploadInBackground(!isCiServer);

        */
    }

    void configureBuildCache(BuildCacheConfigurationAdapter buildCache) {

        /* Example of build cache configuration
        boolean isCiServer = System.getenv().containsKey("CI");

        // Enable the local build cache for all local and CI builds
        // For short-lived CI agents, it makes sense to disable the local build cache
        buildCache.getLocal().setEnabled(true);

        // Only permit store operations to the remote build cache for CI builds
        // Local builds will only read from the remote build cache
        buildCache.getRemote().setEnabled(true);
        buildCache.getRemote().setStoreEnabled(isCiServer);

        */
    }

}
