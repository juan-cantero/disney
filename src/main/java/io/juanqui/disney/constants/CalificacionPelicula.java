package io.juanqui.disney.constants;

public enum CalificacionPelicula {
    UNO(1),DOS(2),TRES(3),CUATRO(4),CINCO(5);
    private int calificacion;

    CalificacionPelicula(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }
}
