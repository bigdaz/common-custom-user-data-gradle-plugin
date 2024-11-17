package com.gradle.develocity.agent.gradle.adapters.internal;

import java.util.Arrays;

public class AdapterTypeUtils {
    private AdapterTypeUtils() {
    }

    private static final String DEVELOCITY_CONFIGURATION = "com.gradle.develocity.agent.gradle.DevelocityConfiguration";
    private static final String GRADLE_ENTERPRISE_EXTENSION = "com.gradle.enterprise.gradleplugin.GradleEnterpriseExtension";
    private static final String BUILD_SCAN_EXTENSION = "com.gradle.scan.plugin.BuildScanExtension";

    public static void checkIsDevelocityConfiguration(Object gradleEnterpriseOrDevelocity) {
        System.out.println("CUSTOM CHECK checkIsDevelocityConfiguration");
        throwIfNotImplementsInterface(gradleEnterpriseOrDevelocity, DEVELOCITY_CONFIGURATION, "Develocity configuration");
    }

    public static void checkIsGradleEnterpriseExtension(Object gradleEnterpriseOrDevelocity) {
        System.out.println("CUSTOM CHECK checkIsGradleEnterpriseExtension");
        throwIfNotImplementsInterface(gradleEnterpriseOrDevelocity, GRADLE_ENTERPRISE_EXTENSION, "Gradle Enterprise extension");
    }

    public static void checkIsBuildScanExtension(Object gradleEnterpriseOrDevelocity) {
        System.out.println("CUSTOM CHECK checkIsBuildScanExtension");
        throwIfNotImplementsInterface(gradleEnterpriseOrDevelocity, BUILD_SCAN_EXTENSION, "Build Scan extension");
    }

    private static void throwIfNotImplementsInterface(Object gradleEnterpriseOrDevelocity, String interfaceName, String expectedTypeDisplayName) {
        if (!implementsInterface(gradleEnterpriseOrDevelocity, interfaceName)) {
            throw new IllegalArgumentException("The supplied object of type '" + gradleEnterpriseOrDevelocity.getClass().getName() + "' is not a " + expectedTypeDisplayName + " object");
        }
    }

    private static boolean implementsInterface(Object object, String interfaceName) {
        System.out.println("IN CUSTOM ADAPTER TYPE UTILS");
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            if (implementsInterface(clazz, interfaceName)) {
                return true;
            }

            clazz = clazz.getSuperclass();
        }

        return false;
    }

    private static boolean implementsInterface(Class<?> clazz, String interfaceName) {
        if (interfaceName.equals(clazz.getName())) {
            return true;
        }

        return Arrays.stream(clazz.getInterfaces()).anyMatch(it -> implementsInterface(it, interfaceName));
    }
}
