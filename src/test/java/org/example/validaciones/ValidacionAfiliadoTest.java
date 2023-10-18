package org.example.validaciones;

import org.example.utilidades.Mensajes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionAfiliadoTest {

    //PARA INSTANCIAR UNA PRUEBA DEBO CERAR UN OBJETO DE LA CLASE QUE VOY A PROBRA

    ValidacionAfiliado validacionAfiliado;

    @BeforeEach //ESTABLECER LAS CONDICIONES INICIALES DE CADA PRUEBA

    public void prepararPruebas(){
        this.validacionAfiliado=new ValidacionAfiliado();

    }

    @Test
    public void validarIdCorrecto(){
        //1.PREPARAR
        Integer idPrueba=50;
        //2.EJECUTAR
        Boolean resultado= Assertions.assertDoesNotThrow(()->this.validacionAfiliado.validarId(idPrueba));
        //3.VERIFICAR
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarIdIncorrecto(){
        //1.
        Integer idPrueba=-100;
        //2.
        Exception resultado = Assertions.assertThrows(Exception.class, ()-> this.validacionAfiliado.validarId(idPrueba));
        //3.
        Assertions.assertEquals(Mensajes.ID_NEGATIVO.getMensaje(),resultado.getMessage());

    }

    @Test
    public void validarNombreCorrecto(){

        //1.PREPARAR

        String nombrePrueba="Karina Cadavid";

        //2.EJECUTAR
        Boolean resultado = Assertions.assertDoesNotThrow(()->this.validacionAfiliado.validarNombre(nombrePrueba));

        //3.VERIFICAR

        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarNombreIncorrectoPorTipoCaracteres(){

        //1.)!
        String nombrePrueba="Karina1234 cadavid789456";

        //2.
        Exception resultado = Assertions.assertThrows(Exception.class,()->this.validacionAfiliado.validarNombre(nombrePrueba));
        //3.
        Assertions.assertEquals(Mensajes.NOMBRES_FORMATO.getMensaje(),resultado.getMessage());

    }

    @Test
    public void validarNombreIncorrectoPorLongitud(){

        //1.
        String nombrePrueba = "oe";
        //2.
        Exception resultado = Assertions.assertThrows(Exception.class, ()->this.validacionAfiliado.validarNombre(nombrePrueba));
        //3.
        Assertions.assertEquals(Mensajes.NOMBRES_LONGITUD.getMensaje(),resultado.getMessage());

    }

    @Test
    public  void validarApellidoCorrecto(){

        //1.
        String apellidoPrueba="Cadavid Orrego";
        //2.
        Boolean resultado =Assertions.assertDoesNotThrow(()-> this.validacionAfiliado.validarApellido(apellidoPrueba));
        //3.
        Assertions.assertTrue(resultado);
    }

    @Test
    public void validarApellidoIncorrectoPorTipoCaracteres(){
        //1.
        String apellidoPrueba="cada7859 orrego12304";
        //2.
        Exception resultado = Assertions.assertThrows(Exception.class,()->this.validacionAfiliado.validarApellido(apellidoPrueba));
        //3.
        Assertions.assertEquals("el apellido no coincide",resultado.getMessage());
    }

    @Test
    public void validarApellidoIncorrectoPorLongitud(){

        //1.
        String apellidoPrueba="";
    }
}