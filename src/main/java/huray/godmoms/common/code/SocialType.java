package huray.godmoms.common.code;

import lombok.Getter;

import java.util.Arrays;

public enum SocialType {
    GOOGLE("google"),
    KAKAO("kakao");

    @Getter
    private String code;

    SocialType(String code) {
        this.code = code;
    }

//    public static SocialType valueOfCode(String code) {
//        return Arrays.stream(SocialType.values()).filter(type -> type.code.equals(code)).findFirst().get();
//    }
}
