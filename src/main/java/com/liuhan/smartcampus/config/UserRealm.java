package com.liuhan.smartcampus.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    //执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("普通");
        return info;
    }
    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        this.setCredentialsMatcher(credentialsMatcher);
        /*UsernamePasswordToken usertoken= (UsernamePasswordToken) token;
        String principal = (String) token.getPrincipal();
        User user = loginMapper.getUserByUserName(usertoken.getUsername());
        System.out.println(token);
        if(user==null){
            return null;
        }
        ByteSource credentialsSalt = ByteSource.Util.bytes(StringUtils.luckyNum());//这里的参数要给个唯一的;

    return new SimpleAuthenticationInfo(principal,user.getPassword(),getName());*/
    return null;
    }
}
