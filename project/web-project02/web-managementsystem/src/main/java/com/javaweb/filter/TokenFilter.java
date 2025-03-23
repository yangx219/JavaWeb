package com.javaweb.filter;

import com.javaweb.utils.CurrentHolder;
import com.javaweb.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
//
@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1. obtenir le chemin de requête
        String requestURI = request.getRequestURI();// /emp/login

        /*2. Vérifier si c'est une requête de connexion.
             Si le chemin contient /login, alors c'est une requête de connexion
             → Autoriser le passage
             Check if it's a login request. If the path contains /login,
             then it's a login request → Allow passage.*/
        if (requestURI.contains("/login")) {
            log.info("Connection requête, laisser passer");
            filterChain.doFilter(request, response);
            return;
        }

        //3. Récupérer le token dans l'en-tête de la requête
        String token = request.getHeader("token");

        //4. vérifier → S'il n'existe pas, cela signifie que l'utilisateur n'est pas connecté, renvoyer un message d'erreur
        if (token == null || token.isEmpty()) {
            log.info("Utilisateur non connecté, veuillez vous connecter d'abord ");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);//401
            return;
        }
        //5. Si le token existe, le Vérifier. En cas d'échec de la vérification, renvoyer un message d'erreur avec le code d'état 401
        try{
            Claims claims = JwtUtils.parseJWT(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("Current employee id : {} " + empId);//enregistrer dans le ThreadLocal
        }catch (Exception e){
            log.info("Token invalide, réponse 401.");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        //6. Si la vérification est réussie, laisser passer
        log.info("Token valide, laisser passer");
        filterChain.doFilter(request, response);

        //7. supprimer le data dans le ThreadLocal
        CurrentHolder.remove();
    }


}
