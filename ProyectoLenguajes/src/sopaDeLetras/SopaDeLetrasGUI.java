/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sopaDeLetras;

import palabras.Palabras;
import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author bryam
 */
public class SopaDeLetrasGUI extends javax.swing.JFrame {

    /**
     * Creates new form SopaDeLetrasGUI
     */
    //Final fin;
    JLabel letra[][];
    String palabra[];//al macenas las palabras en un arreglo de string
    int iniciox[];
    int inicioy[];
    int x;
    int y;
    int cantidadPalabras;
    boolean gano; 
    boolean direccion[];
    Palabras sopa;
    LinkedList<JLabel> palabrasEnGUI = new LinkedList<>();
    public SopaDeLetrasGUI() {
        sopa = new Palabras();
        this.cantidadPalabras = sopa.getPalabras().size();
        
        int lenPalabra = sopa.getLenPalabraMasLarga();
        
        this.x = lenPalabra+8;
        this.y = lenPalabra+4;
        
        initComponents();
        panelSopaLetras.setLayout(new java.awt.GridLayout(this.y, this.x));
        panelPalabras.setLayout(new java.awt.GridLayout(this.cantidadPalabras+2, 1, 25, 25));
        palabra = new String[cantidadPalabras];
        
        int cont=0;
        LinkedList<String> listaPalbras = sopa.getPalabras();
        
        for(String p: listaPalbras){
            palabra[cont] = p;
            cont++;
        }
        
        this.setLocationRelativeTo(null);
        ponerLabelsEnGUI();
        cargar();
        //palabras=new String[cantidadPalabras];
        //palabra=new String[]{"PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA","PRUEBA"};//
        //for (int i = 0; i < letra.length; i++) {
          //  palabras[i]=palabra[i];//pasa la palabra del arreglo label al al arreglo de string
        //}
    }
    
    public void cargar()
    {
        gano=false;
        iniciox=new int[cantidadPalabras];//crea un arreglo de enteros para guadar las posiciones de las palabras en x
        inicioy=new int[cantidadPalabras];//crea un arreglo de enteros para guadar las posiciones de las palabras en y
        direccion=new boolean[cantidadPalabras];//crea un arreglo de enteros para guadar las direcion de las palabras ya sea hacia alante o hacia tras
        celdasdeletras();
        colocarpalabras();
        llenarespaciosvacios();
    }
    
    public void celdasdeletras() 
    {
        letra=new JLabel[y][x];//crea la matriz de celdas donde va cada letra
        for (int i = 0; i < y; i++) 
        {
            for (int j = 0; j < x; j++) {
                letra[i][j]=new JLabel("", javax.swing.SwingConstants.CENTER);//crea la casilla la vacia y con una alineacion centrada
                letra[i][j].setName("");//le pone un nombre a la casilla en este caso no le pone ninguno
                letra[i][j].setBackground(Color.WHITE);//coloca la casilla de color blanco
                letra[i][j].setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // asigna el tipo y el tamaño de la letra
                letra[i][j].setForeground(new java.awt.Color(0, 5, 2));
                letra[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                letra[i][j].setOpaque(true);//esto es para que se pueda ver el color de la casilla o cajonsito donde va la letra
                letra[i][j].setBorder(new javax.swing.border.LineBorder(Color.BLACK, 1));//pone a la casiilla en borde con una linea negra
                letra[i][j].addMouseListener(new java.awt.event.MouseAdapter() {//pone a la casilla a la escucha del mouse para saber cuando se esta dando clic
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        presioneClic(evt);//llama al metodo que debe ejecutarse cuando se da clic
                    }
                });
                panelSopaLetras.add(letra[i][j]);//coloca la pasilla en el panel Sopa_de_letra
            }
        }
    }
    
    public void presioneClic(java.awt.event.MouseEvent evt) {
        if (!gano) {//verifica si gano el juego
            if (evt.getComponent().getBackground().equals(Color.WHITE))//verifica si la casilla esta de color blanco 
            {
                evt.getComponent().setBackground(new java.awt.Color(51, 51, 255));//si esta de color blanco la pone de color azul
                tachar();
            }else if(evt.getComponent().getName().equals(""))//pregunta si la casilla no tiene una letra de alguna palabra
            {
                evt.getComponent().setBackground(Color.WHITE);//pone la casilla de color blanco
            }
        }
    }
    
    public void tachar() 
    {
        System.out.println("\n-------");
        for (int i = 0; i < cantidadPalabras; i++) 
        {
            if (!palabrasEnGUI.get(i).getText().substring(0, 1).equals("<")) {
                System.out.println(iniciox[i]+", "+inicioy[i]+"  ->"+direccion[i]);
                if (tacharLetra(iniciox[i],inicioy[i],palabra[i].length(),direccion[i]))//pregunta si hay una palabra encontrada
                {
                    palabrasEnGUI.get(i).setText("<html><body><s style=\"color:#FF0000\";>"+palabrasEnGUI.get(i).getText()+"</s></body></html>");//tacha la palabra
                    
                    break;
                }
            }
        }
        boolean aux=true;//ayuda para saber si ya todas las palabras estan tachadas
        for (int i = 0; i < palabra.length; i++)
        {
            if (!palabrasEnGUI.get(i).getText().substring(0, 1).equals("<")) 
            {
                aux=false;
                break;
            }
        }
        if (aux) {
            Object[] options = {"Volver al inicio", "Jugar de nuevo"};
            int x = JOptionPane.showOptionDialog(null, "¡Has ganado la partida!",
                "¡¡Felicidades!!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(x==1){
                reiniciarJuego();
            }else if(x==0){
                System.out.println("AQUI SE LLAMA UN METOTDO QUE ME REGRESA AL MENU");
            }
  
            /*if (!(fin instanceof Final)) 
            { //esto comprueba si la ventana no esta en memoria, entonces la instancia
                fin = new Final();   
                gano=true;
            } 
            CentrarVentanaInterna(fin); //usamos el metodo generico para centrar*/
        }
    }
    /*public void CentrarVentanaInterna(JInternalFrame internalFrame) 
    { //pasamos como parametro un objeto de tipo JinternalFrame
        int x = (escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;  //caculas las posiciones x y y 
        int y = (escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;
        if (internalFrame.isShowing()) {// comprobamos si la ventana ya esta ejecutada
            internalFrame.setLocation(x, y); // si es asi solo le colocamos en la mitad
        } 
        else
        {
            escritorio.add(internalFrame); // si no es asi le insertamos dentro del desktoppane
            internalFrame.setLocation(x, y); 
            internalFrame.show(); // y mostramos
        }
    }*/
//    verifica si se puede tachar la letra
    public boolean  tacharLetra(int x,int y,int tamaño,boolean direccion) {
        boolean respuesta=true;
        if (direccion) {
            for (int i = y; i < tamaño+y; i++) {
                if (letra[x][i].getBackground().equals(Color.WHITE)) {
                    respuesta=false;
                    break;
                }
            }
        }else
        {
            for (int j = y; j >y-tamaño; j--) {
                if (letra[x][j].getBackground().equals(Color.WHITE)) {
                    respuesta=false;
                    break;
                }
            }
        }
        return respuesta;
    }
    public void colocarpalabras() {
        
        String palabra[] = new String[cantidadPalabras];
        
        int cont=0;
        LinkedList<String> listaPalbras = sopa.getPalabras();
        
        for(String p: listaPalbras){
            palabra[cont] = p;
            cont++;
        }
        Random random=new Random();//estemetodo ayuda a crear numeros aleatorios
        int iniciax=0;//posicion x donde inicia la palabra
        int iniciay;//posicion y donde inicia la palabra
        int unico[]=NumerosSinRepeticiones(cantidadPalabras);//evita que en una fila se generen mas de una vez
        iniciox=unico;
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].length()<x) {
                iniciax=unico[i];
                iniciay=(int)(random.nextDouble()*x-1);
                int estrae=0;//ayuda para estraer las letras de la palabra
                if (iniciay+palabra[i].length()<x) {
                    for (int j = iniciay; j < iniciay+palabra[i].length(); j++) {
                        letra[iniciax][j].setText(palabra[i].substring(estrae, estrae+1));//estrae una letra de la palabra
                        letra[iniciax][j].setName("1");//pone el nombre a la casilla para que se sepa que hay va una letra de una palabra
                        estrae++;//esto es para que se estraiga la siguiente letra de la palabra
                        inicioy[i]=iniciay;
                        direccion[i]=true;
                    }
                } else if (iniciay-palabra[i].length()>0)
                {
                    for (int j = iniciay; j >iniciay-palabra[i].length() ; j--) {
                        letra[iniciax][j].setText(palabra[i].substring(estrae, estrae+1));
                        letra[iniciax][j].setName("1");
                        estrae++;
                        inicioy[i]=iniciay;
                        direccion[i]=false;
                    }
                }
            }
        }
    }
    public int[] NumerosSinRepeticiones(int repeticiones) {
        int numeros[]=new int[repeticiones];
        for (int i = 0; i < repeticiones; i++) {
            numeros[i]=-1;
        }
        Random random=new Random();
        boolean aux ;//informa si la fila esta o no repetida
        int numero=0;
        for (int x = 0; x < repeticiones; x++) 
        {
            aux = true;
            while (aux) {  
                aux=false;
                numero=(int)(random.nextDouble()*(y+1)-1);
                for (int j = 0; j < numeros.length; j++) {
                    if (numeros[j]==numero) {
                        aux=true;
                        break;
                    }
                }
            }
            numeros[x]=numero;
        }
        return numeros;
    }
    public void llenarespaciosvacios() 
    {
        //este arreglo ayuda a poner las letras del avecedario
        String abc[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Random random=new Random();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (letra[i][j].getText().equals("")) {//si la casilla esta vacia pongale una letra del arreglo abc
                    letra[i][j].setText(abc[(int)(random.nextDouble()*abc.length-1)]);//aqui pone la letra
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSopaLetras = new javax.swing.JPanel();
        panelPalabras = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelSopaLetras.setBackground(new java.awt.Color(165, 83, 83));
        panelSopaLetras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelSopaLetras.setLayout(new java.awt.GridLayout(10, 10));

        panelPalabras.setBackground(new java.awt.Color(133, 91, 133));
        panelPalabras.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panelPalabras.setLayout(new java.awt.GridLayout(1, 1, 30, 30));

        jPanel3.setBackground(new java.awt.Color(128, 102, 74));

        jLabel2.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel2.setText("Sopa de letras");

        jLabel1.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel1.setText("PALABRAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jMenu1.setBackground(new java.awt.Color(0, 102, 102));
        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setText("Reiniciar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSopaLetras, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSopaLetras, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(panelPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void reiniciarJuego(){
        //esta reinicia el juego
        for (int i = 0; i < palabra.length; i++) {
            palabrasEnGUI.get(i).setText(palabra[i]);//asigna a los label de la derecha las palabras
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                panelSopaLetras.remove(letra[i][j]);//quita el panel  Sopa_de_letra
            }
        }
        cargar();//carga el juego
    }
    
    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        reiniciarJuego();
    }//GEN-LAST:event_jMenu1MouseClicked

    
    private void ponerLabelsEnGUI() {
        LinkedList<String> palabras = sopa.getPalabras();
        panelPalabras.add(new JLabel(""));
        for(String palabra: palabras){
            JLabel p = new JLabel(palabra);
            p.setBackground(new java.awt.Color(0, 204, 255));
            p.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            p.setOpaque(true);
            
                panelPalabras.add(p);
                palabrasEnGUI.add(p);
           
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelPalabras;
    private javax.swing.JPanel panelSopaLetras;
    // End of variables declaration//GEN-END:variables

    
}
