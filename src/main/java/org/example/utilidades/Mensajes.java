package org.example.utilidades;

public enum Mensajes {

    ID_NEGATIVO("El id no puede ser negativo"),

    NOMBRES_LONGITUD("El numero de caracteres no es correcto debe estar entre 3 y 40"),

    NOMBRES_FORMATO("el nombre no coincide");

    private String Mensaje;

    Mensajes(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
