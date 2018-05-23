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
@Table(name = "bebidas", catalog = "fastmenu", schema = "")
@NamedQueries({
    @NamedQuery(name = "Bebidas.findAll", query = "SELECT b FROM Bebidas b")
    , @NamedQuery(name = "Bebidas.findById", query = "SELECT b FROM Bebidas b WHERE b.id = :id")
    , @NamedQuery(name = "Bebidas.findByBebida", query = "SELECT b FROM Bebidas b WHERE b.bebida = :bebida")
    , @NamedQuery(name = "Bebidas.findByPrecio", query = "SELECT b FROM Bebidas b WHERE b.precio = :precio")})
public class Bebidas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bebida")
    private String bebida;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;

    public Bebidas() {
    }

    public Bebidas(Integer id) {
        this.id = id;
    }

    public Bebidas(Integer id, String bebida, int precio) {
        this.id = id;
        this.bebida = bebida;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        String oldBebida = this.bebida;
        this.bebida = bebida;
        changeSupport.firePropertyChange("bebida", oldBebida, bebida);
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        int oldPrecio = this.precio;
        this.precio = precio;
        changeSupport.firePropertyChange("precio", oldPrecio, precio);
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
        if (!(object instanceof Bebidas)) {
            return false;
        }
        Bebidas other = (Bebidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fastmenu.Bebidas[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
