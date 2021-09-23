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

@Entity(name="CT_DATTOUR")
@IdClass(CtDatTourID.class)
public class CtDattour implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * IdClass for primary key when using JPA annotations
     */
//	public class CtDatTourID  implements Serializable {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		java.lang.String matour;
//	    java.lang.String cmndNguoidat;
//	    Khachhang khachhang;
//	}
  
    /** Primary key. */
    protected static final String PK = "CtDattourPkCtDattour";


    @Id
    @Column(name="MATOUR", nullable=false, length=12)
    private String matour;
    @Id
    @Column(name="ID_NGUOIDAT", nullable=false, length=12)
    private int id_nguoidat;
    @Column(name="LOAIGIA", precision=10)
    private int loaigia;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="ID_KHACHHANG", nullable=false)
    private Khachhang khachhang;

    /** Default constructor. */
    public CtDattour() {
        super();
    }

    /**
     * Access method for matour.
     *
     * @return the current value of matour
     */
    public String getMatour() {
        return matour;
    }

    /**
     * Setter method for matour.
     *
     * @param aMatour the new value for matour
     */
    public void setMatour(String aMatour) {
        matour = aMatour;
    }

    /**
     * Access method for cmndNguoidat.
     *
     * @return the current value of cmndNguoidat
     */
    public int getIdNguoidat() {
        return id_nguoidat;
    }

    /**
     * Setter method for cmndNguoidat.
     *
     * @param aCmndNguoidat the new value for cmndNguoidat
     */
    public void setIdNguoidat(int aCmndNguoidat) {
        id_nguoidat = aCmndNguoidat;
    }

    /**
     * Access method for loaigia.
     *
     * @return the current value of loaigia
     */
    public int getLoaigia() {
        return loaigia;
    }

    /**
     * Setter method for loaigia.
     *
     * @param aLoaigia the new value for loaigia
     */
    public void setLoaigia(int aLoaigia) {
        loaigia = aLoaigia;
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

    /** Temporary value holder for group key fragment khachhangCmnd */
    private transient String tempKhachhangCmnd;

    /**
     * Gets the key fragment cmnd for member khachhang.
     * If this.khachhang is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setKhachhangCmnd.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Khachhang
     */
    public String getKhachhangCmnd() {
        return (getKhachhang() == null ? tempKhachhangCmnd : getKhachhang().getCmnd());
    }

    /**
     * Sets the key fragment cmnd from member khachhang.
     * If this.khachhang is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getKhachhangCmnd.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aCmnd New value for the key fragment
     * @see Khachhang
     */
    public void setKhachhangCmnd(String aCmnd) {
        if (getKhachhang() == null) {
            tempKhachhangCmnd = aCmnd;
        } else {
            getKhachhang().setCmnd(aCmnd);
        }
    }

    /**
     * Compares the key for this instance with another CtDattour.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CtDattour and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CtDattour)) {
            return false;
        }
        CtDattour that = (CtDattour) other;
        Object myMatour = this.getMatour();
        Object yourMatour = that.getMatour();
        if (myMatour==null ? yourMatour!=null : !myMatour.equals(yourMatour)) {
            return false;
        }
        Object myCmndNguoidat = this.getIdNguoidat();
        Object yourCmndNguoidat = that.getIdNguoidat();
        if (myCmndNguoidat==null ? yourCmndNguoidat!=null : !myCmndNguoidat.equals(yourCmndNguoidat)) {
            return false;
        }
        Object myKhachhangCmnd = this.getKhachhangCmnd();
        Object yourKhachhangCmnd = that.getKhachhangCmnd();
        if (myKhachhangCmnd==null ? yourKhachhangCmnd!=null : !myKhachhangCmnd.equals(yourKhachhangCmnd)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CtDattour.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CtDattour)) return false;
        return this.equalKeys(other) && ((CtDattour)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
//    @Override
//    public int hashCode() {
//        int i;
//        int result = 17;
//        if (getMatour() == null) {
//            i = 0;
//        } else {
//            i = getMatour().hashCode();
//        }
//        result = 37*result + i;
//        if (getIdNguoidat() == null) {
//            i = 0;
//        } else {
//            i = getIdNguoidat().hashCode();
//        }
//        result = 37*result + i;
//        if (getKhachhangCmnd() == null) {
//            i = 0;
//        } else {
//            i = getKhachhangCmnd().hashCode();
//        }
//        result = 37*result + i;
//        return result;
//    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[CtDattour |");
        sb.append(" matour=").append(getMatour());
        sb.append(" cmndNguoidat=").append(getIdNguoidat());
        sb.append(" khachhangCmnd=").append(getKhachhangCmnd());
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
        ret.put("matour", getMatour());
        ret.put("cmndNguoidat", getIdNguoidat());
        ret.put("khachhangCmnd", getKhachhangCmnd());
        return ret;
    }

}
