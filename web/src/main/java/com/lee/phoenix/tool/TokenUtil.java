package com.lee.phoenix.tool;

import com.lee.phoenix.common.consts.Consts;
import com.lee.phoenix.common.enums.AccountType;
import com.lee.phoenix.config.ExtraConfig;
import com.lee.phoenix.entity.User;
import com.lee.phoenix.security.Account;
import com.lee.phoenix.security.AuthUser;
import com.lee.phoenix.security.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;

@Component
public class TokenUtil {
    private final TokenHandler tokenHandler;

    @Autowired
    public TokenUtil(@Value("${token.secret}") String secret) {
        tokenHandler = new TokenHandler(DatatypeConverter.parseBase64Binary(secret));
    }

//    public String getToken(User user) {
//        AuthUser user = new AuthUser(new Account(user.getId(), AccountType.TRAINER, trainer.getName(), trainer.getPhone()));
//        String token = tokenHandler.createTokenForUser(user);
//
//        if (!ExtraConfig.isDev() && Consts.PTTOOL_APP_CLIENT_HEADER.equals(servletRequest.getHeader("client"))) {//App
//            TrainerToken trainerToken = trainerService.findTrainerToken(trainer.getId());
//            if (trainerToken == null) {
//                trainerToken = new TrainerToken();
//                trainerToken.setId(trainer.getId());
//            }
//            trainerToken.setPadToken(token);
//            trainerService.save(trainerToken);
//        }
//
//        return token;
//    }
}
