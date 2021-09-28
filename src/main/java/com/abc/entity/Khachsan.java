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

@Entity(name="KHACHSAN")
public class Khachsan implements Serializable {

    /** Primary key. */
    protected static final String PK = "maks";


    @Id
    @Column(name="MAKS", unique=true, nullable=false, length=12)
    private String maks;
    @Column(name="TENKS", length=200)
    private String tenks;
    @OneToMany(mappedBy="khachsan")
    @JsonIgnore
    private Set<Datkhachsan> datkhachsan;

    /** Default constructor. */
    public Khachsan() {
        super();
    }

    /**
     * Access method for maks.
     *
     * @return the current value of maks
     */
    public String getMaks() {
        return maks;
    }

    /**
     * Setter method for maks.
     *
     * @param aMaks the new value for maks
     */
    public void setMaks(String aMaks) {
        maks = aMaks;
    }

    /**
     * Access method for tenks.
     *
     * @return the current value of tenks
     */
    public String getTenks() {
        return tenks;
    }

    /**
     * Setter method for tenks.
     *
     * @param aTenks the new value for tenks
     */
    public void setTenks(String aTenks) {
        tenks = aTenks;
    }

    /**
     * Access method for datkhachsan.
     *
     * @return the current value of datkhachsan
     */
    public Set<Datkhachsan> getDatkhachsan() {
        return datkhachsan;
    }

    /**
     * Setter method for datkhachsan.
     *
     * @param aDatkhachsan the new value for datkhachsan
     */
    public void setDatkhachsan(Set<Datkhachsan> aDatkhachsan) {
        datkhachsan = aDatkhachsan;
    }

    /**
     * Compares the key for this instance with another Khachsan.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Khachsan and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Khachsan)) {
            return false;
        }
        Khachsan that = (Khachsan) other;
        Object myMaks = this.getMaks();
        Object yourMaks = that.getMaks();
        if (myMaks==null ? yourMaks!=null : !myMaks.equals(yourMaks)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Khachsan.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Khachsan)) return false;
        return this.equalKeys(other) && ((Khachsan)other).equalKeys(this);
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
        if (getMaks() == null) {
            i = 0;
        } else {
            i = getMaks().hashCode();
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
        StringBuffer sb = new StringBuffer("[Khachsan |");
        sb.append(" maks=").append(getMaks());
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
        ret.put("maks", getMaks());
        return ret;
    }

}
