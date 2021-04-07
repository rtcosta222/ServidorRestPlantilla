/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.ListaPlantilla;

/**
 *
 * @author lscar
 */
public class ServicePlantilla {
    
    String url;
    
    public ServicePlantilla(){
        this.url = "https://apidoctoresrosselli.azurewebsites.net/";
    }
    
    private String leerRespuestaApi(InputStream stream) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
        String linea = "";
        StringBuffer data = new StringBuffer();
        String separator = "";
        
        //Leemos las líneas del xml e introducimos '\n' para separarlas. El resultado final
        //será una sola línea.
        while((linea = buffer.readLine()) != null){
            data.append(separator + linea);
            separator = "\n";
        }
        String response = data.toString();
        return response;
    }
    
    public ListaPlantilla getPlantillaSalario(int salario) throws MalformedURLException, IOException, JAXBException{
        // Como con ajax: 
        //  $.ajax({
        //      url: url + request,
        String request = "api/plantilla/salario/" + salario;
        URL peticion = new URL(this.url + request);
        
        HttpURLConnection conexion = (HttpURLConnection)peticion.openConnection();
        //      type: "get",
        conexion.setRequestMethod("GET");
        //      dataType: "xml",
        conexion.setRequestProperty("Accept", "application/xml");
        //      success: function(data){...}});
        if(conexion.getResponseCode() == 200){
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            JAXBContext context = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantilla = (ListaPlantilla)serial.unmarshal(reader);
            return plantilla;
        } else{
            return null;
        }
    }

    public ListaPlantilla getPlantillaFuncion(String funcion) throws MalformedURLException, IOException, JAXBException{
        // Como con ajax: 
        //  $.ajax({
        //      url: url + request,
        String request = "api/plantilla/buscarfuncion/" + funcion;
        URL peticion = new URL(this.url + request);
        
        HttpURLConnection conexion = (HttpURLConnection)peticion.openConnection();
        //      type: "get",
        conexion.setRequestMethod("GET");
        //      dataType: "xml",
        conexion.setRequestProperty("Accept", "application/xml");
        //      success: function(data){...}});
        if(conexion.getResponseCode() == 200){
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            JAXBContext context = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantilla = (ListaPlantilla)serial.unmarshal(reader);
            return plantilla;
        } else{
            return null;
        }
    }
        
    public ListaPlantilla getPlantilla() throws MalformedURLException, IOException, JAXBException{
        // Como con ajax: 
        //  $.ajax({
        //      url: url + request,
        String request = "api/plantilla";
        URL peticion = new URL(this.url + request);
        
        HttpURLConnection conexion = (HttpURLConnection)peticion.openConnection();
        //      type: "get",
        conexion.setRequestMethod("GET");
        //      dataType: "xml",
        conexion.setRequestProperty("Accept", "application/xml");
        //      success: function(data){...}});
        if(conexion.getResponseCode() == 200){
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            JAXBContext context = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantilla = (ListaPlantilla)serial.unmarshal(reader);
            return plantilla;
        } else{
            return null;
        }
    }
}
