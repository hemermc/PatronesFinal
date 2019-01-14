
package com.subastas.patrones.factory;

import com.subastas.commons.Constantes;
import java.sql.Connection;

/**
 *
 * @author Grupo_12
 */
public class CRUDFactory{
    
    public ICRUDGeneral getCRUD(String crudEspecifico, Connection conexion){
        switch (crudEspecifico) {
            case Constantes.CRUD_ARTICULO:
                return new CRUDArticulo(conexion);
            case Constantes.CRUD_COMPRAS:
                return new CRUDCompras(conexion);
            case Constantes.CRUD_TARJETA:
                return new CRUDTarjeta(conexion);
            default:
                break;
        }
        
        return new CRUDArticulo(conexion);
    }
}
