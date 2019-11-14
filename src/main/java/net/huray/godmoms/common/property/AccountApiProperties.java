package net.huray.godmoms.common.property;

import net.huray.godmoms.common.code.SocialType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("account")
public class AccountApiProperties {
    private Map<String, SocialApiProperties> api;

    public SocialApiProperties getApiProperties(SocialType type) {
        return api.get(type.getCode());
    }
}
