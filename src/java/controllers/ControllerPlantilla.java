/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import models.Funciones;
import models.ListaPlantilla;
import models.Plantilla;
import services.ServicePlantilla;

/**
 *
 * @author lscar
 */
public class ControllerPlantilla {
   // Como si fuera un repositorio(service <-> repo).
    ServicePlantilla service;
    
    public ControllerPlantilla(){
        this.service = new ServicePlantilla();
    }
    
    public String getTablaPlantilla() 
                    throws IOException, MalformedURLException, JAXBException{
        ListaPlantilla lista = this.service.getPlantilla();
        List<Plantilla> plantillas = lista.getPlantillas();
        String html = "";
        for(Plantilla p: plantillas){
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getPlantillaFuncion(String funcion) 
                    throws IOException, MalformedURLException, JAXBException{
        ListaPlantilla lista = this.service.getPlantillaFuncion(funcion);
        List<Plantilla> plantillas = lista.getPlantillas();
        String html = "";
        for(Plantilla p: plantillas){
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getPlantillaSalario(int salario) 
                    throws IOException, MalformedURLException, JAXBException{
        ListaPlantilla lista = this.service.getPlantillaSalario(salario);
        List<Plantilla> plantillas = lista.getPlantillas();
        String html = "";
        for(Plantilla p: plantillas){
            html += "<tr>";
            html += "<td>" + p.getApellido() + "</td>";
            html += "<td>" + p.getFuncion() + "</td>";
            html += "<td>" + p.getTurno() + "</td>";
            html += "<td>" + p.getSalario() + "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public String getPlantillaFunciones() 
                    throws IOException, MalformedURLException, JAXBException{
        Funciones funciones = this.service.getPlantillaFunciones();
        ArrayList<String> funcs = funciones.getFuncion();
        String html = "";
        for(String s: funcs){
            html += "<option value='" + s + "'>" + s + "</option>";
        }
        return html;
    }
}
