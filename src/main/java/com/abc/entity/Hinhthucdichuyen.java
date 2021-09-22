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

@Entity(name="HINHTHUCDICHUYEN")
@IdClass(HinhthucdichuyenId.class)
public class Hinhthucdichuyen implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
//    public class HinhthucdichuyenId implements Serializable {
//        Phuongtien phuongtien;
//        Tuyen tuyen;
//    }

    /** Primary key. */
    protected static final String PK = "HinhthucdichuyenPkHinhthucdichuyen";


    @ManyToOne(optional=false)
    @Id
    @JsonIgnore
    @JoinColumn(name="MAPT", nullable=false)
    private Phuongtien phuongtien;
    @ManyToOne(optional=false)
    @Id
    @JsonIgnore
    @JoinColumn(name="MATUYEN", nullable=false)
    private Tuyen tuyen;

    /** Default constructor. */
    public Hinhthucdichuyen() {
        super();
    }

    /**
     * Access method for phuongtien.
     *
     * @return the current value of phuongtien
     */
    public Phuongtien getPhuongtien() {
        return phuongtien;
    }

    /**
     * Setter method for phuongtien.
     *
     * @param aPhuongtien the new value for phuongtien
     */
    public void setPhuongtien(Phuongtien aPhuongtien) {
        phuongtien = aPhuongtien;
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

    /** Temporary value holder for group key fragment phuongtienMapt */
    private transient String tempPhuongtienMapt;

    /**
     * Gets the key fragment mapt for member phuongtien.
     * If this.phuongtien is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPhuongtienMapt.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Phuongtien
     */
    public String getPhuongtienMapt() {
        return (getPhuongtien() == null ? tempPhuongtienMapt : getPhuongtien().getMapt());
    }

    /**
     * Sets the key fragment mapt from member phuongtien.
     * If this.phuongtien is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPhuongtienMapt.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aMapt New value for the key fragment
     * @see Phuongtien
     */
    public void setPhuongtienMapt(String aMapt) {
        if (getPhuongtien() == null) {
            tempPhuongtienMapt = aMapt;
        } else {
            getPhuongtien().setMapt(aMapt);
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
     * Compares the key for this instance with another Hinhthucdichuyen.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Hinhthucdichuyen and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Hinhthucdichuyen)) {
            return false;
        }
        Hinhthucdichuyen that = (Hinhthucdichuyen) other;
        Object myPhuongtienMapt = this.getPhuongtienMapt();
        Object yourPhuongtienMapt = that.getPhuongtienMapt();
        if (myPhuongtienMapt==null ? yourPhuongtienMapt!=null : !myPhuongtienMapt.equals(yourPhuongtienMapt)) {
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
     * Compares this instance with another Hinhthucdichuyen.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Hinhthucdichuyen)) return false;
        return this.equalKeys(other) && ((Hinhthucdichuyen)other).equalKeys(this);
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
        if (getPhuongtienMapt() == null) {
            i = 0;
        } else {
            i = getPhuongtienMapt().hashCode();
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
        StringBuffer sb = new StringBuffer("[Hinhthucdichuyen |");
        sb.append(" phuongtienMapt=").append(getPhuongtienMapt());
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
        ret.put("phuongtienMapt", getPhuongtienMapt());
        ret.put("tuyenMatuyen", getTuyenMatuyen());
        return ret;
    }

}
