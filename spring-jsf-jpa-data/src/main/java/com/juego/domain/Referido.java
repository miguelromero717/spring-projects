/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc-romerosanchez
 */
@Entity
@Table(name = "referidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referido.findAll", query = "SELECT r FROM Referido r")
    , @NamedQuery(name = "Referido.findById", query = "SELECT r FROM Referido r WHERE r.id = :id")
    , @NamedQuery(name = "Referido.findByNombres", query = "SELECT r FROM Referido r WHERE r.nombres = :nombres")
    , @NamedQuery(name = "Referido.findByApellidos", query = "SELECT r FROM Referido r WHERE r.apellidos = :apellidos")
    , @NamedQuery(name = "Referido.findByCedula", query = "SELECT r FROM Referido r WHERE r.cedula = :cedula")
    , @NamedQuery(name = "Referido.findByTelefono", query = "SELECT r FROM Referido r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Referido.findByCiudad", query = "SELECT r FROM Referido r WHERE r.ciudad = :ciudad")
    , @NamedQuery(name = "Referido.findByUsuarioCreacion", query = "SELECT r FROM Referido r WHERE r.usuarioCreacion = :usuarioCreacion")
    , @NamedQuery(name = "Referido.findByFechaCreacion", query = "SELECT r FROM Referido r WHERE r.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Referido.findByUsuarioModificacion", query = "SELECT r FROM Referido r WHERE r.usuarioModificacion = :usuarioModificacion")
    , @NamedQuery(name = "Referido.findByFechaModificacion", query = "SELECT r FROM Referido r WHERE r.fechaModificacion = :fechaModificacion")})
public class Referido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @OneToMany(mappedBy = "idQuienRefiere")
    private List<Referido> referidoList;
    @JoinColumn(name = "id_quien_refiere", referencedColumnName = "id")
    @ManyToOne
    private Referido idQuienRefiere;

    public Referido() {
    }

    public Referido(Integer id) {
        this.id = id;
    }

    public Referido(Integer id, String nombres, String apellidos, String cedula, String telefono, String ciudad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<Referido> getReferidoList() {
        return referidoList;
    }

    public void setReferidoList(List<Referido> referidoList) {
        this.referidoList = referidoList;
    }

    public Referido getIdQuienRefiere() {
        return idQuienRefiere;
    }

    public void setIdQuienRefiere(Referido idQuienRefiere) {
        this.idQuienRefiere = idQuienRefiere;
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
        if (!(object instanceof Referido)) {
            return false;
        }
        Referido other = (Referido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.juego.domain.Referido[ id=" + id + " ]";
    }
    
}
