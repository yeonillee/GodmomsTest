package huray.godmoms.common.property;

import huray.godmoms.common.code.SocialType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("account.api")
public class AccountApiProperties {
    private SocialApiProperties kakao;
    private SocialApiProperties google;

    public SocialApiProperties getApiProperties(SocialType type) {
        switch (type) {
            case GOOGLE:
                return google;
            case KAKAO:
                return kakao;
        }

        return null;
    }
}
