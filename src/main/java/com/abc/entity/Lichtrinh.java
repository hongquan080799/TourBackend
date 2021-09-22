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

@Entity(name="LICHTRINH")
@IdClass(LichtrinhId.class)
public class Lichtrinh implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
//    public class LichtrinhId implements Serializable {
//        Tuyen tuyen;
//        Diadiem diadiem;
//    }

    /** Primary key. */
    protected static final String PK = "LichtrinhPkLichtrinCd415B40Ddd83957";


    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MADIADIEM", nullable=false)
    private Diadiem diadiem;
    @ManyToOne(optional=false)
    @Id
    @JsonIgnore
    @JoinColumn(name="MATUYEN", nullable=false)
    private Tuyen tuyen;
    private String mota;
    /** Default constructor. */
    public Lichtrinh() {
        super();
    }

    /**
     * Access method for diadiem.
     *
     * @return the current value of diadiem
     */
    public Diadiem getDiadiem() {
        return diadiem;
    }

    /**
     * Setter method for diadiem.
     *
     * @param aDiadiem the new value for diadiem
     */
    public void setDiadiem(Diadiem aDiadiem) {
        diadiem = aDiadiem;
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

    
    public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTempTuyenMatuyen() {
		return tempTuyenMatuyen;
	}

	public void setTempTuyenMatuyen(String tempTuyenMatuyen) {
		this.tempTuyenMatuyen = tempTuyenMatuyen;
	}

	public int getTempDiadiemId() {
		return tempDiadiemId;
	}

	public void setTempDiadiemId(int tempDiadiemId) {
		this.tempDiadiemId = tempDiadiemId;
	}

	public static String getPk() {
		return PK;
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

    /** Temporary value holder for group key fragment diadiemId */
    private transient int tempDiadiemId;

    /**
     * Gets the key fragment id for member diadiem.
     * If this.diadiem is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setDiadiemId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Diadiem
     */
    public int getDiadiemId() {
        return (getDiadiem() == null ? tempDiadiemId : getDiadiem().getId());
    }

    /**
     * Sets the key fragment id from member diadiem.
     * If this.diadiem is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getDiadiemId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Diadiem
     */
    public void setDiadiemId(int aId) {
        if (getDiadiem() == null) {
            tempDiadiemId = aId;
        } else {
            getDiadiem().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another Lichtrinh.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Lichtrinh and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Lichtrinh)) {
            return false;
        }
        Lichtrinh that = (Lichtrinh) other;
        Object myTuyenMatuyen = this.getTuyenMatuyen();
        Object yourTuyenMatuyen = that.getTuyenMatuyen();
        if (myTuyenMatuyen==null ? yourTuyenMatuyen!=null : !myTuyenMatuyen.equals(yourTuyenMatuyen)) {
            return false;
        }
        if (this.getDiadiemId() != that.getDiadiemId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Lichtrinh.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Lichtrinh)) return false;
        return this.equalKeys(other) && ((Lichtrinh)other).equalKeys(this);
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
        if (getTuyenMatuyen() == null) {
            i = 0;
        } else {
            i = getTuyenMatuyen().hashCode();
        }
        result = 37*result + i;
        i = getDiadiemId();
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
        StringBuffer sb = new StringBuffer("[Lichtrinh |");
        sb.append(" tuyenMatuyen=").append(getTuyenMatuyen());
        sb.append(" diadiemId=").append(getDiadiemId());
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
        ret.put("tuyenMatuyen", getTuyenMatuyen());
        ret.put("diadiemId", Integer.valueOf(getDiadiemId()));
        return ret;
    }

}
