package huray.godmoms.converter;

import huray.godmoms.common.code.SocialType;
import org.springframework.core.convert.converter.Converter;

public class SocialTypeConverter implements Converter<String, SocialType> {
    @Override
    public SocialType convert(String source) {
        return SocialType.valueOf(source.toUpperCase());
    }
}
