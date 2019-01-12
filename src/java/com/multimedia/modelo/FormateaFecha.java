
package com.multimedia.modelo;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Grupo_12
 */
public class FormateaFecha {

    public static Date comoDate(LocalDate localDate) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        return sqlDate;
    }

    public static LocalDate comoLocalDate(Date date) {
        if(date != null){
            return (LocalDate)Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        }
        else return null;
    }
  
}
