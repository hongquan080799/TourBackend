// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="DIADIEM")
public class Diadiem implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="TENDIADIEM", length=50)
    private String tendiadiem;
    @Column(name="MOTA", length=500)
    private String mota;

    @JsonIgnore
    @OneToMany(mappedBy="diadiem")
    private Set<Lichtrinh> lichtrinh;

    /** Default constructor. */
    public Diadiem() {
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
     * Access method for tendiadiem.
     *
     * @return the current value of tendiadiem
     */
    public String getTendiadiem() {
        return tendiadiem;
    }

    /**
     * Setter method for tendiadiem.
     *
     * @param aTendiadiem the new value for tendiadiem
     */
    public void setTendiadiem(String aTendiadiem) {
        tendiadiem = aTendiadiem;
    }

    /**
     * Access method for mota.
     *
     * @return the current value of mota
     */
    public String getMota() {
        return mota;
    }

    /**
     * Setter method for mota.
     *
     * @param aMota the new value for mota
     */
    public void setMota(String aMota) {
        mota = aMota;
    }

    /**
     * Access method for lichtrinh.
     *
     * @return the current value of lichtrinh
     */
    public Set<Lichtrinh> getLichtrinh() {
        return lichtrinh;
    }

    /**
     * Setter method for lichtrinh.
     *
     * @param aLichtrinh the new value for lichtrinh
     */
    public void setLichtrinh(Set<Lichtrinh> aLichtrinh) {
        lichtrinh = aLichtrinh;
    }

    /**
     * Compares the key for this instance with another Diadiem.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Diadiem and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Diadiem)) {
            return false;
        }
        Diadiem that = (Diadiem) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Diadiem.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Diadiem)) return false;
        return this.equalKeys(other) && ((Diadiem)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Diadiem |");
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
