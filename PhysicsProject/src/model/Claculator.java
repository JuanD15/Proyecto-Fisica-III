package model;

import java.util.HashMap;

/**
 * Clase calculadora que asi mismo funciona como conversor de unidades
 *
 * @author Juan David Carrillo Parra
 */
public class Calculator {

    private HashMap<String, Double> converts;

    public Calculator() {
        converts = new HashMap();
        initConverts();
    }

    /**
     * metodo que inicializa las unidades con su valor en un pascal
     */
    private void initConverts() {
        converts.put("Pa", 101325.0);
        converts.put("bar", 1.01325);
        converts.put("mb", 1013.25);
        converts.put("mmHg", 760.0);
        converts.put("psi", 14.696);
        converts.put("inHg", 29.9213);
    }

    /**
     * Metodo de conversion de unidades
     *
     * @param unitsF unidades origen
     * @param unitsT unidades destino
     * @param value valor a convertir
     * @return el valor convertido
     */
    public Double convertUnits(String unitsF, String unitsT, double value) {
        Double valueR = 0.0;
        if (unitsT.equals("Atm")) {
            valueR = value / converts.get(unitsF);
        } else if (unitsF.equals("Atm")) {
            valueR = value * converts.get(unitsT);
        } else {
            valueR = (value / converts.get(unitsF)) * converts.get(unitsT);
        }
        return (double) Math.round(valueR * 10000d) / 10000d;
    }

    /**
     * Metodo que da las opciones de conversion
     *
     * @return arreglo de opciones de conversion
     */
    public String[] getArr() {
        String[] arrConverts = String.valueOf(converts.keySet()).split(", ");
        for (int i = 0; i < arrConverts.length; i++) {
            arrConverts[i] = arrConverts[i].replace("[", "");
            arrConverts[i] = arrConverts[i].replace("]", "");
        }
        return arrConverts;
    }

    /**
     * Metodo calculador de presion
     *
     * @param force fuerza ejercida
     * @param area area donde se ejerce la fuerza
     * @return la presion ejercida sobre el area
     */
    public double calculatePressure(double force, double area) {
        return force / area;
    }
}
