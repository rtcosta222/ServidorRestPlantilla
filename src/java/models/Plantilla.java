/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lscar
 */

// El valor de "name" debe de coincidir con la etiqueta en el XML.
@XmlRootElement(name = "plantilla")
public class Plantilla {
    private int idPlantilla;
    private String apellido;
    private String funcion;
    private String turno;
    private int salario;
    
    public Plantilla(){}
    
    //El "name" debe de coincidor con el valor de la etiqueta en el xml.
    @XmlElement(name = "idPlantilla")
    public int getIdPlantilla() {
        return idPlantilla;
    }

    public void setIdPlantilla(int idPlantilla) {
        this.idPlantilla = idPlantilla;
    }

    @XmlElement(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @XmlElement(name = "funcion")
    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @XmlElement(name = "turno")
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @XmlElement(name = "salario")
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }    
}
