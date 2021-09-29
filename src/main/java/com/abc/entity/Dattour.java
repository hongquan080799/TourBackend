// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="DATTOUR")
@IdClass(DattourId.class)
public class Dattour implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
//    public class DattourId implements Serializable {
//        Khachhang khachhang;
//        Tour tour;
//    }

    /** Primary key. */
    protected static final String PK = "DattourPkDattour01B1A7131B7397Fa";


    @Column(name="TRANGTHAI", precision=10)
    private int trangthai;
    @Column(name="HTTT", precision=10)
    private int httt;
    @Column(name="SOLUONG", precision=10)
    private int soluong;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MAKH", nullable=false)
    private Khachhang khachhang;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MATOUR", nullable=false)
    private Tour tour;
    @Id
    @JoinColumn(name = "THOIGIAN")
    private LocalDateTime thoigian;

    /** Default constructor. */
    public Dattour() {
        super();
    }

    /**
     * Access method for trangthai.
     *
     * @return the current value of trangthai
     */
    public int getTrangthai() {
        return trangthai;
    }

    /**
     * Setter method for trangthai.
     *
     * @param aTrangthai the new value for trangthai
     */
    public void setTrangthai(int aTrangthai) {
        trangthai = aTrangthai;
    }

    /**
     * Access method for httt.
     *
     * @return the current value of httt
     */
    public int getHttt() {
        return httt;
    }

    /**
     * Setter method for httt.
     *
     * @param aHttt the new value for httt
     */
    public void setHttt(int aHttt) {
        httt = aHttt;
    }

    /**
     * Access method for soluong.
     *
     * @return the current value of soluong
     */
    public int getSoluong() {
        return soluong;
    }

    /**
     * Setter method for soluong.
     *
     * @param aSoluong the new value for soluong
     */
    public void setSoluong(int aSoluong) {
        soluong = aSoluong;
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
    
    public LocalDateTime getThoigian() {
		return thoigian;
	}

	public void setThoigian(LocalDateTime thoigian) {
		this.thoigian = thoigian;
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

    /** Temporary value holder for group key fragment tourMatour */
    private transient String tempTourMatour;

    /**
     * Gets the key fragment matour for member tour.
     * If this.tour is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setTourMatour.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Tour
     */
    public String getTourMatour() {
        return (getTour() == null ? tempTourMatour : getTour().getMatour());
    }

    /**
     * Sets the key fragment matour from member tour.
     * If this.tour is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getTourMatour.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aMatour New value for the key fragment
     * @see Tour
     */
    public void setTourMatour(String aMatour) {
        if (getTour() == null) {
            tempTourMatour = aMatour;
        } else {
            getTour().setMatour(aMatour);
        }
    }

    /**
     * Compares the key for this instance with another Dattour.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Dattour and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Dattour)) {
            return false;
        }
        Dattour that = (Dattour) other;
        Object myKhachhangCmnd = this.getKhachhangCmnd();
        Object yourKhachhangCmnd = that.getKhachhangCmnd();
        if (myKhachhangCmnd==null ? yourKhachhangCmnd!=null : !myKhachhangCmnd.equals(yourKhachhangCmnd)) {
            return false;
        }
        Object myTourMatour = this.getTourMatour();
        Object yourTourMatour = that.getTourMatour();
        if (myTourMatour==null ? yourTourMatour!=null : !myTourMatour.equals(yourTourMatour)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Dattour.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Dattour)) return false;
        return this.equalKeys(other) && ((Dattour)other).equalKeys(this);
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
        if (getKhachhangCmnd() == null) {
            i = 0;
        } else {
            i = getKhachhangCmnd().hashCode();
        }
        result = 37*result + i;
        if (getTourMatour() == null) {
            i = 0;
        } else {
            i = getTourMatour().hashCode();
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
        StringBuffer sb = new StringBuffer("[Dattour |");
        sb.append(" khachhangCmnd=").append(getKhachhangCmnd());
        sb.append(" tourMatour=").append(getTourMatour());
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
        ret.put("khachhangCmnd", getKhachhangCmnd());
        ret.put("tourMatour", getTourMatour());
        return ret;
    }

}
