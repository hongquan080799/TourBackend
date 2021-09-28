// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TUYEN")
public class Tuyen implements Serializable {

    /** Primary key. */
    protected static final String PK = "matuyen";


    @Id
    @Column(name="MATUYEN", unique=true, nullable=false, length=12)
    private String matuyen;
    @Column(name="TENTUYEN", length=100)
    private String tentuyen;
    
    @OneToMany(mappedBy="tuyen")
    private Set<Datkhachsan> datkhachsan;
    
    @OneToMany(mappedBy="tuyen")
    private Set<Datnhahang> datnhahang;
 
    @OneToMany(mappedBy="tuyen")
    private Set<Hinhthucdichuyen> hinhthucdichuyen;

    @OneToMany(mappedBy="tuyen")
    private Set<Lichtrinh> lichtrinh;
    
    @OneToMany(mappedBy="tuyen")
    private List<Photo> photo;
    
    @OneToMany(mappedBy="tuyen")
    private Set<Tour> tour;
    private String diadiemxp;
    public String getDiadiemxp() {
		return diadiemxp;
	}

	public void setDiadiemxp(String diadiemxp) {
		this.diadiemxp = diadiemxp;
	}

	private String mota;
    private String thoigian;
    
    
    public void updateTuyen(Tuyen tuyen)
    {
    	if (tuyen.tentuyen != null)
    	{
    		this.setTentuyen(tuyen.getTentuyen());
    	}
    	
    	if (tuyen.getMota() != null)
    	{
    		this.setMota(tuyen.getMota());
    	}
    	
    	if (tuyen.getDiadiemxp() != null)
    	{
    		this.setDiadiemxp(tuyen.getDiadiemxp());
    	}
    	
    	if (tuyen.thoigian != null)
    	{
    		this.setThoigian(tuyen.getThoigian());
    	}
    }

    /** Default constructor. */
    public Tuyen() {
        super();
    }

    /**
     * Access method for matuyen.
     *
     * @return the current value of matuyen
     */
    public String getMatuyen() {
        return matuyen;
    }

    /**
     * Setter method for matuyen.
     *
     * @param aMatuyen the new value for matuyen
     */
    public void setMatuyen(String aMatuyen) {
        matuyen = aMatuyen;
    }

    /**
     * Access method for tentuyen.
     *
     * @return the current value of tentuyen
     */
    public String getTentuyen() {
        return tentuyen;
    }

    
    public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	/**
     * Setter method for tentuyen.
     *
     * @param aTentuyen the new value for tentuyen
     */
    public void setTentuyen(String aTentuyen) {
        tentuyen = aTentuyen;
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
     * Access method for datnhahang.
     *
     * @return the current value of datnhahang
     */
    public Set<Datnhahang> getDatnhahang() {
        return datnhahang;
    }

    /**
     * Setter method for datnhahang.
     *
     * @param aDatnhahang the new value for datnhahang
     */
    public void setDatnhahang(Set<Datnhahang> aDatnhahang) {
        datnhahang = aDatnhahang;
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
     * Access method for photo.
     *
     * @return the current value of photo
     */
    public List<Photo> getPhoto() {
        return photo;
    }

    /**
     * Setter method for photo.
     *
     * @param aPhoto the new value for photo
     */
    public void setPhoto(List<Photo> aPhoto) {
        photo = aPhoto;
    }

    /**
     * Access method for tour.
     *
     * @return the current value of tour
     */
    public Set<Tour> getTour() {
        return tour;
    }

    /**
     * Setter method for tour.
     *
     * @param aTour the new value for tour
     */
    public void setTour(Set<Tour> aTour) {
        tour = aTour;
    }

    
    /**
     * Compares the key for this instance with another Tuyen.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Tuyen and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Tuyen)) {
            return false;
        }
        Tuyen that = (Tuyen) other;
        Object myMatuyen = this.getMatuyen();
        Object yourMatuyen = that.getMatuyen();
        if (myMatuyen==null ? yourMatuyen!=null : !myMatuyen.equals(yourMatuyen)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Tuyen.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tuyen)) return false;
        return this.equalKeys(other) && ((Tuyen)other).equalKeys(this);
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
        if (getMatuyen() == null) {
            i = 0;
        } else {
            i = getMatuyen().hashCode();
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
        StringBuffer sb = new StringBuffer("[Tuyen |");
        sb.append(" matuyen=").append(getMatuyen());
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
        ret.put("matuyen", getMatuyen());
        return ret;
    }

}
