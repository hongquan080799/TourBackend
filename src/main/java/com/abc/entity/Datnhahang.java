// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="DATNHAHANG")
@IdClass(DatnhahangId.class)
public class Datnhahang implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
//     */
//    public class DatnhahangId implements Serializable {
//        Nhahang nhahang;
//        Tuyen tuyen;
//    }

    /** Primary key. */
    protected static final String PK = "DatnhahangPkDatnhahang";


    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MANH", nullable=false)
    private Nhahang nhahang;
    @ManyToOne(optional=false)
    @Id
    @JsonIgnore
    @JoinColumn(name="MATUYEN", nullable=false)
    private Tuyen tuyen;

    /** Default constructor. */
    public Datnhahang() {
        super();
    }

    /**
     * Access method for nhahang.
     *
     * @return the current value of nhahang
     */
    public Nhahang getNhahang() {
        return nhahang;
    }

    /**
     * Setter method for nhahang.
     *
     * @param aNhahang the new value for nhahang
     */
    public void setNhahang(Nhahang aNhahang) {
        nhahang = aNhahang;
    }

    /**
     * Access method for tuyen.
     *
     * @return the current value of tuyen
     */
    public Tuyen getTuyen() {
        return tuyen;
    }

    /**
     * Setter method for tuyen.
     *
     * @param aTuyen the new value for tuyen
     */
    public void setTuyen(Tuyen aTuyen) {
        tuyen = aTuyen;
    }

    /** Temporary value holder for group key fragment nhahangManh */
    private transient String tempNhahangManh;

    /**
     * Gets the key fragment manh for member nhahang.
     * If this.nhahang is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setNhahangManh.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Nhahang
     */
    public String getNhahangManh() {
        return (getNhahang() == null ? tempNhahangManh : getNhahang().getManh());
    }

    /**
     * Sets the key fragment manh from member nhahang.
     * If this.nhahang is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getNhahangManh.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aManh New value for the key fragment
     * @see Nhahang
     */
    public void setNhahangManh(String aManh) {
        if (getNhahang() == null) {
            tempNhahangManh = aManh;
        } else {
            getNhahang().setManh(aManh);
        }
    }

    /** Temporary value holder for group key fragment tuyenMatuyen */
    private transient String tempTuyenMatuyen;

    /**
     * Gets the key fragment matuyen for member tuyen.
     * If this.tuyen is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setTuyenMatuyen.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Tuyen
     */
    public String getTuyenMatuyen() {
        return (getTuyen() == null ? tempTuyenMatuyen : getTuyen().getMatuyen());
    }

    /**
     * Sets the key fragment matuyen from member tuyen.
     * If this.tuyen is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getTuyenMatuyen.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aMatuyen New value for the key fragment
     * @see Tuyen
     */
    public void setTuyenMatuyen(String aMatuyen) {
        if (getTuyen() == null) {
            tempTuyenMatuyen = aMatuyen;
        } else {
            getTuyen().setMatuyen(aMatuyen);
        }
    }

    /**
     * Compares the key for this instance with another Datnhahang.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Datnhahang and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Datnhahang)) {
            return false;
        }
        Datnhahang that = (Datnhahang) other;
        Object myNhahangManh = this.getNhahangManh();
        Object yourNhahangManh = that.getNhahangManh();
        if (myNhahangManh==null ? yourNhahangManh!=null : !myNhahangManh.equals(yourNhahangManh)) {
            return false;
        }
        Object myTuyenMatuyen = this.getTuyenMatuyen();
        Object yourTuyenMatuyen = that.getTuyenMatuyen();
        if (myTuyenMatuyen==null ? yourTuyenMatuyen!=null : !myTuyenMatuyen.equals(yourTuyenMatuyen)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Datnhahang.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Datnhahang)) return false;
        return this.equalKeys(other) && ((Datnhahang)other).equalKeys(this);
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
        if (getNhahangManh() == null) {
            i = 0;
        } else {
            i = getNhahangManh().hashCode();
        }
        result = 37*result + i;
        if (getTuyenMatuyen() == null) {
            i = 0;
        } else {
            i = getTuyenMatuyen().hashCode();
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
        StringBuffer sb = new StringBuffer("[Datnhahang |");
        sb.append(" nhahangManh=").append(getNhahangManh());
        sb.append(" tuyenMatuyen=").append(getTuyenMatuyen());
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
        ret.put("nhahangManh", getNhahangManh());
        ret.put("tuyenMatuyen", getTuyenMatuyen());
        return ret;
    }

}
