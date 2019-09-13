package com.lee.phoenix.security;

import com.lee.phoenix.common.enums.AccountType;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class AuthUserAuthority implements GrantedAuthority {
    private String authority;

    public AuthUserAuthority(String authority) {
        this.authority = authority;
    }

    public static Set<AuthUserAuthority> fromAccountType(Integer accountTypeId) {
        HashSet<AuthUserAuthority> authorities = new HashSet<>();
        AccountType accountType = AccountType.valueOf(accountTypeId);
        switch (accountType) {
            case ADMIN:
                authorities.add(new AuthUserAuthority("ROLE_ADMIN"));
                break;
            case USER:
                authorities.add(new AuthUserAuthority("ROLE_USER"));
            default:
                break;
        }
        return authorities;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
