// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="PHUONGTIEN")
public class Phuongtien implements Serializable {

    /** Primary key. */
    protected static final String PK = "mapt";


    @Id
    @Column(name="MAPT", unique=true, nullable=false, length=12)
    private String mapt;
    @Column(name="TENPT", length=200)
    private String tenpt;
    
    @OneToMany(mappedBy="phuongtien")
    private Set<Hinhthucdichuyen> hinhthucdichuyen;

    /** Default constructor. */
    public Phuongtien() {
        super();
    }

    /**
     * Access method for mapt.
     *
     * @return the current value of mapt
     */
    public String getMapt() {
        return mapt;
    }

    /**
     * Setter method for mapt.
     *
     * @param aMapt the new value for mapt
     */
    public void setMapt(String aMapt) {
        mapt = aMapt;
    }

    /**
     * Access method for tenpt.
     *
     * @return the current value of tenpt
     */
    public String getTenpt() {
        return tenpt;
    }

    /**
     * Setter method for tenpt.
     *
     * @param aTenpt the new value for tenpt
     */
    public void setTenpt(String aTenpt) {
        tenpt = aTenpt;
    }

    /**
     * Access method for hinhthucdichuyen.
     *
     * @return the current value of hinhthucdichuyen
     */
    public Set<Hinhthucdichuyen> getHinhthucdichuyen() {
        return hinhthucdichuyen;
    }

    /**
     * Setter method for hinhthucdichuyen.
     *
     * @param aHinhthucdichuyen the new value for hinhthucdichuyen
     */
    public void setHinhthucdichuyen(Set<Hinhthucdichuyen> aHinhthucdichuyen) {
        hinhthucdichuyen = aHinhthucdichuyen;
    }

    /**
     * Compares the key for this instance with another Phuongtien.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Phuongtien and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Phuongtien)) {
            return false;
        }
        Phuongtien that = (Phuongtien) other;
        Object myMapt = this.getMapt();
        Object yourMapt = that.getMapt();
        if (myMapt==null ? yourMapt!=null : !myMapt.equals(yourMapt)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Phuongtien.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Phuongtien)) return false;
        return this.equalKeys(other) && ((Phuongtien)other).equalKeys(this);
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
        if (getMapt() == null) {
            i = 0;
        } else {
            i = getMapt().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[Phuongtien |");
        sb.append(" mapt=").append(getMapt());
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
        ret.put("mapt", getMapt());
        return ret;
    }

}
