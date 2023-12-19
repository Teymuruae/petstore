package io.petstore.helpers.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface Configs extends Config {

    @Key("baseUrl")
    String getBaseUrl();
}