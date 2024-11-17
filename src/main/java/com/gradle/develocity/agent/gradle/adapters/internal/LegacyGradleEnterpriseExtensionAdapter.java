package com.gradle.develocity.agent.gradle.adapters.internal;

import com.gradle.develocity.agent.gradle.adapters.enterprise.GradleEnterpriseExtensionAdapter;

import org.gradle.caching.configuration.AbstractBuildCache;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegacyGradleEnterpriseExtensionAdapter extends GradleEnterpriseExtensionAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(LegacyGradleEnterpriseExtensionAdapter.class);

    public LegacyGradleEnterpriseExtensionAdapter(Object extension) {
        super(extension);
    }

    @Override
    public @Nullable Class<? extends AbstractBuildCache> getBuildCache() {
        warnAboutUnsupportedOperation("getBuildCache()");
        return null;
    }

    private static void warnAboutUnsupportedOperation(String op) {
        LOG.warn("Gradle Enterprise extension does not support '" + op + "' operation");
    }

}
