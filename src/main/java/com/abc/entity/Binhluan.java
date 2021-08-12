// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="BINHLUAN")
public class Binhluan implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="NOIDUNG", length=500)
    private String noidung;
    @ManyToOne
    @JoinColumn(name="MAKH")
    private Khachhang khachhang;
    @ManyToOne
    @JoinColumn(name="MATOUR")
    private Tour tour;

    /** Default constructor. */
    public Binhluan() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for noidung.
     *
     * @return the current value of noidung
     */
    public String getNoidung() {
        return noidung;
    }

    /**
     * Setter method for noidung.
     *
     * @param aNoidung the new value for noidung
     */
    public void setNoidung(String aNoidung) {
        noidung = aNoidung;
    }

    /**
     * Access method for khachhang.
     *
     * @return the current value of khachhang
     */
    public Khachhang getKhachhang() {
        return khachhang;
    }

    /**
     * Setter method for khachhang.
     *
     * @param aKhachhang the new value for khachhang
     */
    public void setKhachhang(Khachhang aKhachhang) {
        khachhang = aKhachhang;
    }

    /**
     * Access method for tour.
     *
     * @return the current value of tour
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * Setter method for tour.
     *
     * @param aTour the new value for tour
     */
    public void setTour(Tour aTour) {
        tour = aTour;
    }

    /**
     * Compares the key for this instance with another Binhluan.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Binhluan and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Binhluan)) {
            return false;
        }
        Binhluan that = (Binhluan) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Binhluan.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Binhluan)) return false;
        return this.equalKeys(other) && ((Binhluan)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Binhluan |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
