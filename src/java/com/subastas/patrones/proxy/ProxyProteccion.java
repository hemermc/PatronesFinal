
package com.subastas.patrones.proxy;

import com.subastas.commons.Constantes;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo_12
 */
public class ProxyProteccion {
    
    public Boolean permitirAcceso(HttpSession session){
        return (session.getAttribute(Constantes.USUARIO) != null);
    }
}
