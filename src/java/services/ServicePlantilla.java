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
import models.Funciones;
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
        //será una sola línea:
        //
        // - "buffer" data format: <datos>\n
        //                             <dato>\n
        //                                <dat>01234</dat>\n
        //                             </dato>\n
        //                             <dato>\n
        //                                <dat>56789</dat>\n
        //                             </dato>\n
        //                         </datos>\n
        // - "linea" data format:  <datos>
        //                             <dato>
        //                                <dat>01234</dat>
        //                             </dato>
        //                             <dato>
        //                                <dat>56789</dat>
        //                             </dato>
        //                         </datos>
        
        while((linea = buffer.readLine()) != null){
            data.append(separator + linea);
            separator = "\n";
        }
        
        // - "data" data format:  
        //      <datos>\n<dato>\n<dat>01234</dat>\n</dato>\n<dato>\n<dat>56789</dat>\n
        //                             </dato>\n</datos>\n
        
        return data.toString();
    }
    
    private ListaPlantilla getRequestPlantilla(String request) throws MalformedURLException, IOException, JAXBException{
        URL peticion = new URL(this.url + request);        
        HttpURLConnection conexion = (HttpURLConnection)peticion.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/xml");
        
        if(conexion.getResponseCode() == 200){
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            // XML ->java classes
            JAXBContext context = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantilla = (ListaPlantilla) serial.unmarshal(reader);
            return plantilla;
        } else{
            return null;
        }
    }
    
    public ListaPlantilla getPlantillaSalario(int salario) 
                            throws MalformedURLException, IOException, JAXBException{
        String request = "api/plantilla/salario/" + salario;
        return this.getRequestPlantilla(request);
    }

    public ListaPlantilla getPlantillaFuncion(String funcion) 
                            throws MalformedURLException, IOException, JAXBException{
        // Como con ajax: 
        //  $.ajax({
        //      url: url + request,
        String request = "api/plantilla/buscarfuncion/" + funcion;
        URL peticion = new URL(this.url + request);
        
        HttpURLConnection conexion = (HttpURLConnection) peticion.openConnection();
        //      type: "get",
        conexion.setRequestMethod("GET");
        //      dataType: "xml",
        conexion.setRequestProperty("Accept", "application/xml");
        //      success: function(data){...}
        //  });
        if(conexion.getResponseCode() == 200){

            // Secuencia de objetos: 
            //      conexion -> stream -> data -> (reader)serial <- context(ListaPlantilla)
            //                                            ||
            //                                            \/
            //                                         plantilla

            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            JAXBContext context = JAXBContext.newInstance(ListaPlantilla.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            ListaPlantilla plantilla = (ListaPlantilla) serial.unmarshal(reader);
            return plantilla;
        } else{
            return null;
        }
    }

    public ListaPlantilla getPlantilla()
                            throws MalformedURLException, IOException, JAXBException{
        // Como con ajax: 
        //  $.ajax({
        //      url: url + request,
        String request = "api/plantilla";
        return this.getRequestPlantilla(request);
    }
     
    public Funciones getPlantillaFunciones() 
                        throws MalformedURLException, IOException, JAXBException{

        String request = "api/plantilla/buscarfunciones";
        URL peticion = new URL(this.url + request);        
        HttpURLConnection conexion = (HttpURLConnection)peticion.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", "application/xml");
        
        if(conexion.getResponseCode() == 200){
            InputStream stream = conexion.getInputStream();
            String data = this.leerRespuestaApi(stream);
            // XML ->java classes
            JAXBContext context = JAXBContext.newInstance(Funciones.class);
            Unmarshaller serial = context.createUnmarshaller();
            StringReader reader = new StringReader(data);
            Funciones funciones = (Funciones) serial.unmarshal(reader);
            return funciones;
        } else{
            return null;
        }
    }
}
