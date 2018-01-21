package com.apress.prospring5.ch4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Named;

@Named("messageProvider")
@NoArgsConstructor
public class ConfigurableMessageProvider implements MessageProvider {
    @Getter @Setter private String message = "Default message";

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

}
