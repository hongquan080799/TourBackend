// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name="PHUTRACH_TOUR")
@IdClass(PhutrachTour.PhutrachTourId.class)
public class PhutrachTour implements Serializable {

    /**
     * IdClass for primary key when using JPA annotations
     */
    public class PhutrachTourId implements Serializable {
        Tour tour;
        Nhanvien nhanvien;
    }

    /** Primary key. */
    protected static final String PK = "PhutrachTourPkPhutrachTour";


    @Column(name="TUNGAY")
    private LocalDate tungay;
    @Column(name="DENNGAY")
    private LocalDate denngay;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MANV", nullable=false)
    private Nhanvien nhanvien;
    @ManyToOne(optional=false)
    @Id
    @JoinColumn(name="MATOUR", nullable=false)
    private Tour tour;

    /** Default constructor. */
    public PhutrachTour() {
        super();
    }

    /**
     * Access method for tungay.
     *
     * @return the current value of tungay
     */
    public LocalDate getTungay() {
        return tungay;
    }

    /**
     * Setter method for tungay.
     *
     * @param aTungay the new value for tungay
     */
    public void setTungay(LocalDate aTungay) {
        tungay = aTungay;
    }

    /**
     * Access method for denngay.
     *
     * @return the current value of denngay
     */
    public LocalDate getDenngay() {
        return denngay;
    }

    /**
     * Setter method for denngay.
     *
     * @param aDenngay the new value for denngay
     */
    public void setDenngay(LocalDate aDenngay) {
        denngay = aDenngay;
    }

    /**
     * Access method for nhanvien.
     *
     * @return the current value of nhanvien
     */
    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    /**
     * Setter method for nhanvien.
     *
     * @param aNhanvien the new value for nhanvien
     */
    public void setNhanvien(Nhanvien aNhanvien) {
        nhanvien = aNhanvien;
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

    /** Temporary value holder for group key fragment nhanvienManv */
    private transient String tempNhanvienManv;

    /**
     * Gets the key fragment manv for member nhanvien.
     * If this.nhanvien is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setNhanvienManv.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Nhanvien
     */
    public String getNhanvienManv() {
        return (getNhanvien() == null ? tempNhanvienManv : getNhanvien().getManv());
    }

    /**
     * Sets the key fragment manv from member nhanvien.
     * If this.nhanvien is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getNhanvienManv.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aManv New value for the key fragment
     * @see Nhanvien
     */
    public void setNhanvienManv(String aManv) {
        if (getNhanvien() == null) {
            tempNhanvienManv = aManv;
        } else {
            getNhanvien().setManv(aManv);
        }
    }

    /**
     * Compares the key for this instance with another PhutrachTour.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PhutrachTour and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PhutrachTour)) {
            return false;
        }
        PhutrachTour that = (PhutrachTour) other;
        Object myTourMatour = this.getTourMatour();
        Object yourTourMatour = that.getTourMatour();
        if (myTourMatour==null ? yourTourMatour!=null : !myTourMatour.equals(yourTourMatour)) {
            return false;
        }
        Object myNhanvienManv = this.getNhanvienManv();
        Object yourNhanvienManv = that.getNhanvienManv();
        if (myNhanvienManv==null ? yourNhanvienManv!=null : !myNhanvienManv.equals(yourNhanvienManv)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PhutrachTour.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PhutrachTour)) return false;
        return this.equalKeys(other) && ((PhutrachTour)other).equalKeys(this);
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
        if (getTourMatour() == null) {
            i = 0;
        } else {
            i = getTourMatour().hashCode();
        }
        result = 37*result + i;
        if (getNhanvienManv() == null) {
            i = 0;
        } else {
            i = getNhanvienManv().hashCode();
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
        StringBuffer sb = new StringBuffer("[PhutrachTour |");
        sb.append(" tourMatour=").append(getTourMatour());
        sb.append(" nhanvienManv=").append(getNhanvienManv());
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
        ret.put("tourMatour", getTourMatour());
        ret.put("nhanvienManv", getNhanvienManv());
        return ret;
    }

}
