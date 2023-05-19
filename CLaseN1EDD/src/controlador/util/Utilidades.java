/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.util;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioExceptio;
import modelo.Sucursal;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;


/**
 *
 * @author alyce
 */
public class Utilidades {
    public static void imprimir(Object[]objs){
        System.out.println("Lista de "+objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }
    public static Double sumarVentas(Sucursal s) throws VacioExceptio, PosicionException{
        if (s.getListaEnlazada().size()!=null) {
            Double ventas = 0.0 ;
            for (int i = 0; i < 12; i++) {    
                 ventas += s.getListaEnlazada().get(i).getValor();
                
            }
            return ventas;
        } else {
            
        }
        return 0.0;
    }
    
        public static Double mediaVentas(Sucursal s) throws  VacioExceptio, PosicionException{
            Double suma = sumarVentas(s);
            if (suma == 0 ) {
                return suma;
            }else 
            return suma / s.getListaEnlazada().size();
            
       
}
         public static <Object> void guardarJson(Object obj,String archivo) throws IOException{
         ObjectMapper JSON_MAPPER = new ObjectMapper();
         JSON_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
         JSON_MAPPER.writeValue(new File(archivo+".json"),obj);
        }
         
         
         public static <Object> Object cargarJson(Class<Object> claseobj,String archivo) throws IOException{
         ObjectMapper JSON_MAPPER = new ObjectMapper();
         Object objeto = JSON_MAPPER.readValue(new File(archivo),claseobj);
         return objeto;
        }
         
        public static void guardarSucursales(Sucursal s) {
        ListaEnlazada<Sucursal> lista = listaSucursal();
        lista.InsertarNodo(s);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(lista);
        try ( PrintWriter pw = new PrintWriter(new File("asignaturas.json"))) {
            pw.write(jsonString);
        } catch (Exception e) {
            System.out.println("Error en el metodo de guardar en utilidades: " + e);
        }
    }
    public static ListaEnlazada<Sucursal> listaSucursal() {
        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("sucursal.json"));
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();
//            Persona[] arrayLista = new Gson().fromJson(json, Persona[].class);
            Type tipoLista = new TypeToken<ListaEnlazada<Sucursal>>() {
            }.getType();
//            System.out.println("Tipolist " + tipoLista);
//            List a = stringToArray(json, Persona[].class);
            lista = new Gson().fromJson(json, tipoLista);

        } catch (Exception e) {
            System.out.println("Error en utilidades del metodo listar: " + e);
        }
        return lista;
    }

        
        
    }
    


