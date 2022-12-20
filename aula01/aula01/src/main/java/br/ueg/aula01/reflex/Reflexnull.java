package br.ueg.aula01.reflex;

import org.hibernate.service.spi.ServiceException;

import javax.persistence.Column;
import java.lang.reflect.Field;

public class Reflexnull<Entidade> {

    public void ValidarCampoNulo(Entidade entidade){
        Class<?> clas = entidade.getClass();
        Field[] fields = clas.getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(Column.class)){
                Column anotation = field.getAnnotation(Column.class);
                if(anotation.nullable()==false){
                    try{
                        field.setAccessible(true);
                        if(field.get(entidade) == null || field.get(entidade).toString().isEmpty()){
                          throw new ServiceException("Campos em branco");
                        }
                    }catch (IllegalArgumentException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
