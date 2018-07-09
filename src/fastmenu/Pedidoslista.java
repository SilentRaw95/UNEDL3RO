/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastmenu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author maike
 */
@Entity
@Table(name = "pedidoslista", catalog = "fastmenu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pedidoslista.findAll", query = "SELECT p FROM Pedidoslista p")
    , @NamedQuery(name = "Pedidoslista.findById", query = "SELECT p FROM Pedidoslista p WHERE p.id = :id")
    , @NamedQuery(name = "Pedidoslista.findByIdPedido", query = "SELECT p FROM Pedidoslista p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedidoslista.findByIdPlatillo", query = "SELECT p FROM Pedidoslista p WHERE p.idPlatillo = :idPlatillo")
    , @NamedQuery(name = "Pedidoslista.findByNombre", query = "SELECT p FROM Pedidoslista p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pedidoslista.findByTipo", query = "SELECT p FROM Pedidoslista p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pedidoslista.findByCantidad", query = "SELECT p FROM Pedidoslista p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pedidoslista.findByTotal", query = "SELECT p FROM Pedidoslista p WHERE p.total = :total")})
public class Pedidoslista implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_platillo")
    private int idPlatillo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;

    public Pedidoslista() {
    }

    public Pedidoslista(Integer id) {
        this.id = id;
    }

    public Pedidoslista(Integer id, int idPedido, int idPlatillo, String nombre, String tipo, int cantidad, double total) {
        this.id = id;
        this.idPedido = idPedido;
        this.idPlatillo = idPlatillo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        int oldIdPedido = this.idPedido;
        this.idPedido = idPedido;
        changeSupport.firePropertyChange("idPedido", oldIdPedido, idPedido);
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        int oldIdPlatillo = this.idPlatillo;
        this.idPlatillo = idPlatillo;
        changeSupport.firePropertyChange("idPlatillo", oldIdPlatillo, idPlatillo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        int oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        changeSupport.firePropertyChange("cantidad", oldCantidad, cantidad);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        double oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidoslista)) {
            return false;
        }
        Pedidoslista other = (Pedidoslista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fastmenu.Pedidoslista[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
