/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ayesa.cursoweb;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author japar
 */
public class Partida {

    private String id;
    private Date fechaCreacion;
    private String jugadorA;
    private String jugadaA;
    private String jugadorB;
    private String jugadaB;

    public Partida() {
        this.id = UUID.randomUUID().toString();
        fechaCreacion = new Date();
    }

    public Partida(String jugadorA, String jugadaA, String jugadorB, String jugadaB) {
        this();
        this.jugadorA = jugadorA;
        this.jugadaA = jugadaA;
        this.jugadorB = jugadorB;
        this.jugadaB = jugadaB;
    }

    public String resultado() {
        String result = null;
        String ganador = null;
        if (getJugadaA() == null || getJugadaA().equals((""))) {
            result = "El jugador " + getJugadorA() + " debe proporcionar una jugada";
        } else if (getJugadaA() == null || getJugadaA().equals((""))) {
            result = "El jugador " + getJugadorA() + " debe proporcionar una jugada";
        } else if (getJugadaA().equals(getJugadaB())) {
            result = "Empate! Ambos habeis escogido " + getJugadaA();
        } else {
            switch (getJugadaA()) {
                case "PIEDRA":
                    ganador=getJugadaB().equals("TIJERAS")?getJugadorA():getJugadorB();
                    break;
                case "PAPEL":
                    ganador=getJugadaB().equals("PIEDRA")?getJugadorA():getJugadorB();
                    break;
                case "TIJERAS":
                    ganador=getJugadaB().equals("PAPEL")?getJugadorA():getJugadorB();
                    break;
            }
            result="El ganador es el jugador "+ganador;
        }
        return result;
    }

    public String getGanador(){
        String ganador="";    
        if (!getJugadaA().equals(getJugadaB())) {            
            switch (getJugadaA()) {
                case "PIEDRA":
                    ganador=getJugadaB().equals("TIJERAS")?getJugadorA():getJugadorB();
                    break;
                case "PAPEL":
                    ganador=getJugadaB().equals("PIEDRA")?getJugadorA():getJugadorB();
                    break;
                case "TIJERAS":
                    ganador=getJugadaB().equals("PAPEL")?getJugadorA():getJugadorB();
                    break;
            }
        }
        return ganador;
    }
    
    public static String generarJugadaAleatoria() {
        String[] jugadas = {"PIEDRA", "PAPEL", "TIJERAS"};
        return jugadas[(int) Math.floor(Math.random() * jugadas.length)];
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @return the jugadorA
     */
    public String getJugadorA() {
        return jugadorA;
    }

    /**
     * @param jugadorA the jugadorA to set
     */
    public void setJugadorA(String jugadorA) {
        this.jugadorA = jugadorA;
    }

    /**
     * @return the jugadaA
     */
    public String getJugadaA() {
        return jugadaA;
    }

    /**
     * @param jugadaA the jugadaA to set
     */
    public void setJugadaA(String jugadaA) {
        this.jugadaA = jugadaA;
    }

    /**
     * @return the jugadorB
     */
    public String getJugadorB() {
        return jugadorB;
    }

    /**
     * @param jugadorB the jugadorB to set
     */
    public void setJugadorB(String jugadorB) {
        this.jugadorB = jugadorB;
    }

    /**
     * @return the jugadaB
     */
    public String getJugadaB() {
        return jugadaB;
    }

    /**
     * @param jugadaB the jugadaB to set
     */
    public void setJugadaB(String jugadaB) {        
        this.jugadaB = jugadaB;
    }
    
    public boolean terminada(){
        return jugadaA!=null && jugadaB!=null;
    }
    
    public boolean completa(){
        return jugadorA!=null && jugadorB!=null;
    }
}
