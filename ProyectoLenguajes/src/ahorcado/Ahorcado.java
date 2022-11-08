package ahorcado;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;
import palabras.*;
/**
 *
 * @author bryam
 */
public class Ahorcado {
    private String palabraSecreta;
    private boolean palabraValida;
    private String palabaConGuiones;
    private int contadorIntentos;
    private char caracter;
    private int contadorAciertos;
    private LinkedList<String>letrasEncontradas;
    private LinkedList<Character> letrasIncorrectas;
    private String palabra;
    private String numeros[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public Ahorcado() {
        contadorAciertos=0;
        contadorIntentos=0;
        palabraValida = false;
        letrasEncontradas=new LinkedList<>();
        letrasIncorrectas=new LinkedList<>();
        palabaConGuiones="";
        Palabras palabras = new Palabras();
        LinkedList<String> listaPalabras = palabras.getPalabras();
        //String palabras[]={"BANANO", "PERA", "MANGO", "NARANJA", "UVA", "JOCOTE", "CEREZA", "HIGO",
        //"MANZANA", "CIRUELA", "ALMENDRA", "NUEZ", "CASTAÑA", "PISTACHO", "KIWI"};
        int aleatorio=(int)(Math.random()*listaPalabras.size()); 
        palabra=listaPalabras.get(aleatorio);
        palabraSecreta=palabraSecretaGuiones(palabra);
        palabraGuiones(palabra);
    }
    
    public String getPalabra(){
        return this.palabra;
    }
    
    String palabraSecretaGuiones(String palabra){
        String palabra2="";
        for(int indice=0;indice< palabra.length(); indice++){           
            if(indice==0){
                palabra2=palabra2+palabra.substring(indice, indice+1);
            }else{
                 palabra2=palabra2+" "+palabra.substring(indice, indice+1);
            }
        }
        System.out.println(palabra2);
        return palabra2;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
    
    public void palabraGuiones(String palabra){
        int contador = 0;
        while(contador < palabra.length()){//Para saber cuantos guiones bajos lleva el string
            if("".equals(palabaConGuiones)){
                palabaConGuiones+="_";
            }else{
            palabaConGuiones+=" _";
            }
            contador++;
        }
        
    } 

    public String getPalabaConGuiones() {
        return palabaConGuiones;
    }
    
    
    public String buscaLetra(String entradaLetra, GraficaAhorcado grafica){      
        caracter=entradaLetra.charAt(0); 
        if(letrasIncorrectas.contains(caracter)){
            grafica.setInformacion("La letra ya fue usada y no está en la palabra");
            return palabaConGuiones;
        }
        palabraValida=verificaPalabra(caracter);      
        if (palabraValida==true) {
            grafica.setInformacion("La letra está en la plabra");
            return palabaConGuiones;          
        } else {
            contadorIntentos++;   
            this.letrasIncorrectas.add(caracter);
                if(contadorIntentos== 1){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO1.png");
                    grafica.setInformacion("La letra no está en la plabra");
              
                }           
                else if(contadorIntentos== 2){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO2.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }          
                else if(contadorIntentos== 3){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO3.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }           
              else if(contadorIntentos== 4) {
                    grafica.cambiarImagen("./src/Imagenes/PERDIO4.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }
               else if(contadorIntentos== 5){
                    grafica.cambiarImagen("./src/Imagenes/PERDIO5.png");
                    grafica.setInformacion("La letra no está en la plabra");
                }
                else if(contadorIntentos== 6){
                    grafica.cambiarImagen("./src/Imagenes/PERDIOFINAL.png");
                    grafica.setInformacion(null);
                }
            }
            return palabaConGuiones;
    }
    
    boolean verificaPalabra(char caracter){
        boolean verificado=false;
        for(String letra: letrasEncontradas){
            if(letra.charAt(0)==caracter){
                return true;
            }
        }

        for(int j=0; j< palabraSecreta.length(); j++){//recorre la palabra secreta
            char palabra= palabraSecreta.charAt(j);//sacar caracter de la posici�n j del string
            //ciclo que si encuetra palabra igual la reemplaza en los guiones bajos
            if(palabra == caracter){
                palabaConGuiones=(palabaConGuiones.substring(0, j)+ caracter+palabaConGuiones.substring(j+1, palabaConGuiones.length()));
                verificado=true;
                contadorAciertos++;
            }
            if(verificado){
                letrasEncontradas.add(String.valueOf(caracter));
            }
        }
        return verificado;
    }
    public boolean esNumero(String digito){
        
        boolean numero = false;
        int cont = 0;
        while(cont < 9){
            if(numeros[cont].equals(digito)){
                numero = true;
                break;
            }
            cont++;
        }
        
        return numero;
        
    }
}
