package com.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//Code de réponse : 1 signifie succès, 0 signifie échec
    private String msg;  //Message de réponse
    private Object data; //Données retournées

    //Réponse de succès pour les opérations d'ajout, de suppression et de modification
    public static Result success(){
        return new Result(1,"success",null);
    }
    //Réponse de succès pour les opérations de recherche
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //Réponse d'échec
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
