package ejercicios.triangulo;

/**
 * Triangulo
 */

public class Triangulo {

    // Lados, vertices y ángulos
    // por comodidad, A, B y C.
    private double ladoA;
    private double ladoB;
    private double ladoC;

    // Constructor
    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    // Getters y Setters
    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    // Saber si es rectángulo
    public boolean esRectangulo(double la, double lb, double lc) {
        double hipotenusa, catetoMenor, catetoMayor;
        if ((la > lb) && (la > lc)) {
            hipotenusa = la;
            if (lb > lc) {
                catetoMayor = lb;
                catetoMenor = lc;
            } else {
                catetoMayor = lc;
                catetoMenor = lb;
            }
        } else if ((lb > la) && (lb > lc)) {
            hipotenusa = lb;
            if (la > lc) {
                catetoMayor = la;
                catetoMenor = lc;
            } else {
                catetoMayor = lc;
                catetoMenor = la;
            }
        } else {
            hipotenusa = lc;
            if (la > lb) {
                catetoMayor = la;
                catetoMenor = lb;
            } else {
                catetoMayor = lb;
                catetoMenor = la;
            }
        }
        // pitágoras
        if (((catetoMayor*catetoMayor) + (catetoMenor*catetoMenor)) == (hipotenusa*hipotenusa)){
            return true;
        } else {
            return false;
        }
    }

    // Saber si es escaleno: todos los lados longitudes diferentes
    public boolean esEscaleno(double la, double lb, double lc) {
        if ((la != lb) && (la != lc) && (lb != lc)) {
            return true;
        } else {
            return false;
        }
    }

    // Saber si es isósceles: 2 lados iguales (pero sólo 2)
    public boolean esIsosceles(double la, double lb, double lc) {
        if ((la == lb) && (la == lc)) {
            return true;
        } else if ((lb == la) && (lb == lc)) {
            return true;
        } else if ((lc == la) && (lc == lb)) {
            return true;
        } else {
            return false;
        }
    }

    // Saber si es equilátero por la medidad de los lados
    public boolean esEquilatero(double la, double lb, double lc) {
        if ((la == lb) && (la == lc) && (lb == lc)) {
            return true;
        } else {
            return false;
        }
    }
}