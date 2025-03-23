package com.javaweb.interceptor;

import com.javaweb.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*//1. Récupérer l'URL de la requête
        String url = request.getRequestURL().toString();

        //2. Vérifier si l'URL contient "login". Si oui, cela signifie une demande de connexion, donc on autorise.
        if(url.contains("login")){ //Demande de connexion
            log.info("Requête de connexion détectée, autorisation accordée");
            return true;
        }
*/
        //3. Récupérer le jeton (token) dans l'en-tête de la requête.
        String jwt = request.getHeader("token");

        //4. Vérifier si le jeton existe. S'il est absent, renvoyer une erreur (non authentifié)
        if(!StringUtils.hasLength(jwt)){ //jwt vide
            log.info("Le jeton JWT est manquant, retour d'une erreur");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //5. Analyser le jeton. En cas d'échec, renvoyer une erreur (non authentifié).
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Échec de l'analyse du jeton, retour d'une erreur");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //6. Autoriser la requête à passer.
        log.info("Token valide, autorisation accordée");
        return true;
    }

}
