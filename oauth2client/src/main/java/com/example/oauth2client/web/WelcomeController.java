package com.example.oauth2client.web;


import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping
    public Object currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
//        Map<String, Object> attributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
//
//        // Retrieve the ID token from the attributes map
//        String idToken = (String) attributes.get("id_token");
//
////        // You can now use the idToken as needed
        Map<String, Object> map = new HashMap<>();

//        return map;
        OidcUserAuthority arr = (OidcUserAuthority) oAuth2AuthenticationToken.getAuthorities().toArray()[0];
        map.put("id_token", arr.getIdToken());
        return map;
//        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
}