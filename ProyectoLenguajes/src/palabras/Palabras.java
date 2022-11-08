package palabras;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;
import java.io.*;

/**
 *
 * @author bryam
 */
public class Palabras {
    private LinkedList<String> palabras;
    private int lenPalabraMasLarga;

    public Palabras() {
        this.lenPalabraMasLarga = 0;
        palabras = new LinkedList<>();
        
        try{
            
            BufferedReader bf = new BufferedReader(new FileReader("src\\palabras.txt"));
            String lector;
            while((lector = bf.readLine()) != null){             
                palabras.add(lector);
                if(lector.length() > this.lenPalabraMasLarga){
                    this.lenPalabraMasLarga = lector.length();
                }
            }
            
        }catch(IOException e){
            System.err.println("No se encontró el TXT con las palabras");
        }
    }

    public int getLenPalabraMasLarga() {
        return lenPalabraMasLarga;
    }

    public LinkedList<String> getPalabras() {
        return palabras;
    }
    
    
}
