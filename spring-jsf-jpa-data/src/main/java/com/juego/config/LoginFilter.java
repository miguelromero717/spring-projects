package com.juego.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juego.controllers.LoginController;

public class LoginFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    /**
     * Metodo constructor
     */
    public LoginFilter() {
    }

    /**
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // Obtengo el bean que representa el usuario desde el scope sesi�n        
        //SeUsuario usuario = (SeUsuario) req.getSession().getAttribute("usuario");
        LoginController loginController = (LoginController)req.getSession().getAttribute("usuario");
        
        //Proceso la URL que est� requiriendo el cliente
        String urlStr = req.getRequestURL().toString().toLowerCase();        
        //Si no requiere protecci�n contin�o normalmente.
        if (noProteger(urlStr)) {
            chain.doFilter(request, response);
            return;
        }
        //El usuario no est� logueado
        if (loginController == null) {
            res.sendRedirect(req.getContextPath() + "/views/index.xhtml");
            return;
        }
        chain.doFilter(request, response);
    }

    /**
     * 
     * @param urlStr
     * @return 
     */
    private boolean noProteger(String urlStr) {
        if (urlStr.endsWith("/views/index.xhtml"))
            return true;
        if (urlStr.contains("/resources/"))
            return true;
        if (urlStr.contains("/js/"))
            return true;
        if (urlStr.contains("/css/"))
            return true;
        return urlStr.contains("/javax.faces.resource/");
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     * @param filterConfig 
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug)
                log("LoginFilter:Initializing filter");
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null)
            return ("LoginFilter()");

        StringBuilder sb = new StringBuilder("LoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    /**
     * 
     * @param t
     * @return 
     */
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stackTrace;
    }

    /**
     * 
     * @param msg 
     */
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}