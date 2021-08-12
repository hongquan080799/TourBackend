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

@Entity(name="DATKHACHSAN")
@IdClass(DatkhachsanId.class)
public class Datkhachsan implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class DatkhachsanId implements Serializable {
        Khachsan khachsan;
        Tuyen tuyen;
    }

    /** Primary key. */
    protected static final String PK = "DatkhachsanPkDatkhachsan";


    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MAKS", nullable=false)
    private Khachsan khachsan;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MATUYEN", nullable=false)
    private Tuyen tuyen;

    /** Default constructor. */
    public Datkhachsan() {
        super();
    }

    /**
     * Access method for khachsan.
     *
     * @return the current value of khachsan
     */
    public Khachsan getKhachsan() {
        return khachsan;
    }

    /**
     * Setter method for khachsan.
     *
     * @param aKhachsan the new value for khachsan
     */
    public void setKhachsan(Khachsan aKhachsan) {
        khachsan = aKhachsan;
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

    /** Temporary value holder for group key fragment khachsanMaks */
    private transient String tempKhachsanMaks;

    /**
     * Gets the key fragment maks for member khachsan.
     * If this.khachsan is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setKhachsanMaks.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Khachsan
     */
    public String getKhachsanMaks() {
        return (getKhachsan() == null ? tempKhachsanMaks : getKhachsan().getMaks());
    }

    /**
     * Sets the key fragment maks from member khachsan.
     * If this.khachsan is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getKhachsanMaks.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aMaks New value for the key fragment
     * @see Khachsan
     */
    public void setKhachsanMaks(String aMaks) {
        if (getKhachsan() == null) {
            tempKhachsanMaks = aMaks;
        } else {
            getKhachsan().setMaks(aMaks);
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
     * Compares the key for this instance with another Datkhachsan.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Datkhachsan and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Datkhachsan)) {
            return false;
        }
        Datkhachsan that = (Datkhachsan) other;
        Object myKhachsanMaks = this.getKhachsanMaks();
        Object yourKhachsanMaks = that.getKhachsanMaks();
        if (myKhachsanMaks==null ? yourKhachsanMaks!=null : !myKhachsanMaks.equals(yourKhachsanMaks)) {
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
     * Compares this instance with another Datkhachsan.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Datkhachsan)) return false;
        return this.equalKeys(other) && ((Datkhachsan)other).equalKeys(this);
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
        if (getKhachsanMaks() == null) {
            i = 0;
        } else {
            i = getKhachsanMaks().hashCode();
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
        StringBuffer sb = new StringBuffer("[Datkhachsan |");
        sb.append(" khachsanMaks=").append(getKhachsanMaks());
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
        ret.put("khachsanMaks", getKhachsanMaks());
        ret.put("tuyenMatuyen", getTuyenMatuyen());
        return ret;
    }

}
