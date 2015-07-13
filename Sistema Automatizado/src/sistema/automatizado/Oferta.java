/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.automatizado;

/**
 *
 * @author Irene
 */
public class Oferta {
    
    private String codigo;
    private String lapso;
    private int nroSecciones;

    public Oferta(String codigo, String lapso, int nroSecciones) {
        this.codigo = codigo;
        this.lapso = lapso;
        this.nroSecciones = nroSecciones;
    }

    
    public Oferta() {
        this.lapso = "";
        this.nroSecciones = 0;
    }   

    public int getNroSecciones() {
        return nroSecciones;
    }

    public void setNroSecciones(int nroSecciones) {
        this.nroSecciones = nroSecciones;
    }
    

    public String getLapso() {
        return lapso;
    }

    public void setLapso(String lapso) {
        this.lapso = lapso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
