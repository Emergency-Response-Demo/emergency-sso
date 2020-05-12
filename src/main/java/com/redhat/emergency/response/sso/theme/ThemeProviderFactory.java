package com.redhat.emergency.response.sso.theme;

import java.net.URL;
import java.util.Enumeration;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.theme.ClasspathThemeProvider;
import org.keycloak.theme.ClasspathThemeProviderFactory;
import org.keycloak.theme.ThemeProvider;

public class ThemeProviderFactory extends ClasspathThemeProviderFactory {

    public ThemeProviderFactory() {
        super("coreui");
    }

    @Override
    public ThemeProvider create(KeycloakSession session) {
        return new ClasspathThemeProvider(themes);
    }

    @Override
    public void init(Config.Scope config) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(KEYCLOAK_THEMES_JSON);
            while (resources.hasMoreElements()) {
                loadThemes(classLoader, resources.nextElement().openStream());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load themes", e);
        }
    }

}
