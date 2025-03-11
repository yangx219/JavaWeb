package com.javaweb.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")//intercepter toutes les requêtes
@Slf4j
public class DemoFilter implements Filter {

    //Méthode d'initialisation : exécutée une seule fois lors du démarrage du serveur web
    //Initialization method: executed once when the web server starts.

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("DemoFilter init...");
    }

    //Exécuté après l'interception（拦截） de la requête, peut être exécuté plusieurs fois
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("DemoFilter doFilter: Requête interceptée...");
        //Autoriser le passage
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("DemoFilter.destroy...");
    }
}
