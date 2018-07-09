/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastmenu;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author maike
 */
public class ItemMenu extends javax.swing.JPanel {
    
    /**
     * Creates new form ItemMenu
     */
    MenuCliente variables = new MenuCliente();
    DefaultListModel listModel = new DefaultListModel();
    
    public Menu platillo;
    public ItemMenu(Menu p) {
        System.out.println("works");
        this.platillo=p;
        initComponents();
        this.name.setText(p.getNombre());
        this.price.setText(""+p.getPrecio()+" $");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add = new javax.swing.JButton();
        price = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();

        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setText("+");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        price.setText("PRICE");

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setText("BOTTOM TEXT");

        cantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add)
                .addGap(18, 18, 18)
                .addComponent(name)
                .addGap(18, 18, 18)
                .addComponent(price)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(price)
                    .addComponent(name)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        String despacito = cantidad.getText();
        int precio = Integer.parseInt(despacito);
        if(precio < 1){
            JOptionPane.showMessageDialog(null, "No puedes colocar cantidad negativa");
        } else {
            int posicion;
            //primer valor es temporal
            Pedidoslista temp = new Pedidoslista(platillo.getId(), 0, platillo.getId(), null, null, 0, 0);
            //System.out.println(variables.orden.contains(temp));
            
            if (variables.orden.contains(temp)) {
                //en caso de añadir un producto repetido
                posicion = variables.orden.indexOf(temp);
                int newCant = variables.orden.get(posicion).getCantidad()+Integer.parseInt(cantidad.getText());
                variables.orden.get(posicion).setCantidad(newCant);
                variables.orden.get(posicion).setTotal(newCant*platillo.getPrecio());
                variables.editList(posicion, variables.orden.get(posicion).getCantidad(), variables.orden.get(posicion).getTotal());
                cantidad.setText("");
            } else {
                //en caso de que sea algo nnuevo
                variables.orden.add(new Pedidoslista(0, 0, platillo.getId(), platillo.getTipo(), platillo.getNombre(), Integer.parseInt(cantidad.getText()), platillo.getPrecio()*Integer.parseInt(cantidad.getText()) ));
                variables.ADDlista_pedidos("id: "+platillo.getId()+" "+platillo.getNombre()+" cantidad: "+cantidad.getText()+" precio total: "+platillo.getPrecio()*Integer.parseInt(cantidad.getText()) );
                cantidad.setText("");
            }
        }
    }//GEN-LAST:event_addActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel name;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
