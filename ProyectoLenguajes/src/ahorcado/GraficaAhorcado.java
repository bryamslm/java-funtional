package ahorcado;

import Funcional.Profundidad;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.Timer;

public class GraficaAhorcado extends javax.swing.JFrame {

    Ahorcado ahorcado;
    private Timer t;
    private int h, m, s, cs;

    public GraficaAhorcado(String p, Ahorcado ahorcado) {
        this.ahorcado = ahorcado;
        palabraGanadora = p;
        initComponents();
        this.setLocationRelativeTo(null);
        h = 0;
        m = 0;
        s = 0;
        cs = 0;
        t = new Timer(10, acciones);
        t.start();

        actualizarLabel();
    }
    private ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++cs;
            if (cs == 100) {
                cs = 0;
                ++s;
            }
            if (s == 60) {
                s = 0;
                ++m;
            }
            if (m == 60) {
                m = 0;
                ++h;
            }
            actualizarLabel();
        }

    };

    private void actualizarLabel() {
        String tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        etiquetaTiempo.setText(tiempo);
    }

    public void cambiarImagen(String url) {
        this.imagen.setIcon(new javax.swing.ImageIcon(url));
    }

    public void setPalabraGuiones(String palabra) {
        palabraSecreta.setText(palabra);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        palabraSecreta = new javax.swing.JLabel();
        dale = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        letra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        info = new javax.swing.JLabel();
        dale2 = new javax.swing.JButton();
        dale1 = new javax.swing.JButton();
        etiquetaTiempo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dale3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe Print", 3, 36)); // NOI18N
        jLabel3.setText("Ahorcado!");

        jLabel4.setFont(new java.awt.Font("Segoe Print", 3, 22)); // NOI18N
        jLabel4.setText("Escribe una letra:");

        palabraSecreta.setFont(new java.awt.Font("Segoe Print", 3, 36)); // NOI18N
        palabraSecreta.setText("_ _ _ _ _ _ _ _ _ _ _");

        dale.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        dale.setText("Dale");
        dale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daleActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe Print", 3, 36)); // NOI18N
        jLabel6.setText("Palabra:");

        letra.setFont(new java.awt.Font("Segoe Print", 3, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N
        jLabel7.setText("Información:");

        info.setFont(new java.awt.Font("Segoe Print", 3, 18)); // NOI18N

        dale2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        dale2.setText("Salir");
        dale2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dale2ActionPerformed(evt);
            }
        });

        dale1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        dale1.setText("Reiniciar juego");
        dale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dale1ActionPerformed(evt);
            }
        });

        etiquetaTiempo.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        etiquetaTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTiempo.setText("00:00:00:00");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel5.setText("Tiempo:");

        dale3.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        dale3.setText("Solucion automática");
        dale3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dale3MouseClicked(evt);
            }
        });
        dale3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dale3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(palabraSecreta, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dale3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dale1)
                                .addGap(18, 18, 18)
                                .addComponent(dale2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dale, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(letra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaTiempo)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(etiquetaTiempo)
                                .addComponent(jLabel5)))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(palabraSecreta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(letra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dale)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dale1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(dale3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(dale2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void imprimirGano() {
        String tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
        t.stop();
        JOptionPane.showMessageDialog(rootPane, "¡Felicidades, ha ganado! Tiempo: " + tiempo);
    }

    private void daleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daleActionPerformed
        // TODO add your handling code here:

        if (letra.getText().length() != 1) {
            setInformacion("Solo se permite ingresar un digito");
        } else if (ahorcado.esNumero(letra.getText())) {
            setInformacion("No se permiten números");
        } else {
            String palabraG = ahorcado.buscaLetra(letra.getText().toUpperCase(), this);
            System.out.println(palabraG);

            palabraSecreta.setText(palabraG);
            if (palabraG.trim().equals(palabraGanadora)) {
                imprimirGano();
            }
        }
        letra.setText("");
    }//GEN-LAST:event_daleActionPerformed

    private void dale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dale1ActionPerformed
        // TODO add your handling code here:
        GraficaAhorcado grafica;
        Ahorcado ahorcado = new Ahorcado();
        String palabraSecreta = ahorcado.getPalabraSecreta();
        grafica = new GraficaAhorcado(palabraSecreta, ahorcado);
        String palabraConGuiones = ahorcado.getPalabaConGuiones();
        grafica.setPalabraGuiones(palabraConGuiones);
        grafica.cambiarImagen("./src/Imagenes/HORCAVACIA.png");
        grafica.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_dale1ActionPerformed

    private void dale2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dale2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_dale2ActionPerformed

    private void dale3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dale3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dale3ActionPerformed

    private void dale3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dale3MouseClicked
        
        
        String palabra = this.ahorcado.getPalabra();
        int tamañoPalabra = palabra.length();
        int cont = 0;
        ArrayList espacio = new ArrayList();
        espacio.add(" ");
        ArrayList listaPalabra = new ArrayList();
        LinkedList<ArrayList> listaPalabraOculta = new LinkedList<ArrayList>();
        while(cont<tamañoPalabra){
            listaPalabra.add(palabra.charAt(cont));
            listaPalabraOculta.add(espacio);
            cont++;
        }
        Profundidad.profundidadAux(listaPalabraOculta, listaPalabra);
        String solucion = this.ahorcado.getPalabra();
        String tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
            t.stop();
        JOptionPane.showMessageDialog(rootPane, "Tiempo: " + tiempo+"\nSOLUCIÓN: "+ solucion);

    }//GEN-LAST:event_dale3MouseClicked
    public void setInformacion(String informacion) {
        if (informacion == null) {
            String tiempo = (h <= 9 ? "0" : "") + h + ":" + (m <= 9 ? "0" : "") + m + ":" + (s <= 9 ? "0" : "") + s + ":" + (cs <= 9 ? "0" : "") + cs;
            t.stop();
            String solucion = this.ahorcado.getPalabra();
            JOptionPane.showMessageDialog(rootPane, "Has perdido, tiempo: " + tiempo+"\nSOLUCIÓN: "+ solucion);
        } else {
            info.setText(informacion);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dale;
    private javax.swing.JButton dale1;
    private javax.swing.JButton dale2;
    private javax.swing.JButton dale3;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField letra;
    private javax.swing.JLabel palabraSecreta;
    // End of variables declaration//GEN-END:variables

    private String palabraGanadora;
}
