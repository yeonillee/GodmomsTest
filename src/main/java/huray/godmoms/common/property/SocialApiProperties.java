package huray.godmoms.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@Getter
@Setter
public class SocialApiProperties {
    private String clientId;
    private String clientSecret;
    private String accountUrl;
    private String tokenUrl;
    private Map<String, String> params;
}
