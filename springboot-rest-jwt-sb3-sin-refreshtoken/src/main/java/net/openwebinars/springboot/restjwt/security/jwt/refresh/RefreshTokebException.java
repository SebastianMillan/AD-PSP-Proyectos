package net.openwebinars.springboot.restjwt.security.jwt.refresh;

import net.openwebinars.springboot.restjwt.security.errorhandling.JwtTokenException;

public class RefreshTokebException extends JwtTokenException {
    public RefreshTokebException(String msg){
        super(msg);
    }
}
