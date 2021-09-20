// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.abc.request.NhanvienRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="NHANVIEN")
public class Nhanvien implements Serializable {

    /** Primary key. */
    protected static final String PK = "manv";

    @Id
    @Column(name="MANV", unique=true, nullable=false, length=12)
    private String manv;
    @Column(name="TENNV", length=100)
    private String tennv;
    @Column(name="SDT", length=12)
    private String sdt;
    @Column(name="DIACHI", length=200)
    private String diachi;
    @Column(name="EMAIL", length=200)
    private String email;
    @Column(name="GIOITINH", precision=10)
    private int gioitinh;
    @Column(name="CHUCVU", length=200)
    private String chucvu;
    private String photo;
    
    @ManyToOne
    @JoinColumn(name="USERNAME")
    private Taikhoan taikhoan;
    @JsonIgnore
    @OneToMany(mappedBy="nhanvien")
    private Set<PhutrachTour> phutrachTour;

    /** Default constructor. */
    public Nhanvien() {
        super();
    }

    /**
     * Access method for manv.
     *
     * @return the current value of manv
     */
    
    
    public String getManv() {
        return manv;
    }

    public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
     * Setter method for manv.
     *
     * @param aManv the new value for manv
     */
    public void setManv(String aManv) {
        manv = aManv;
    }

    /**
     * Access method for tennv.
     *
     * @return the current value of tennv
     */
    public String getTennv() {
        return tennv;
    }

    /**
     * Setter method for tennv.
     *
     * @param aTennv the new value for tennv
     */
    public void setTennv(String aTennv) {
        tennv = aTennv;
    }

    /**
     * Access method for sdt.
     *
     * @return the current value of sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * Setter method for sdt.
     *
     * @param aSdt the new value for sdt
     */
    public void setSdt(String aSdt) {
        sdt = aSdt;
    }

    /**
     * Access method for diachi.
     *
     * @return the current value of diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     * Setter method for diachi.
     *
     * @param aDiachi the new value for diachi
     */
    public void setDiachi(String aDiachi) {
        diachi = aDiachi;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for gioitinh.
     *
     * @return the current value of gioitinh
     */
    public int getGioitinh() {
        return gioitinh;
    }

    /**
     * Setter method for gioitinh.
     *
     * @param aGioitinh the new value for gioitinh
     */
    public void setGioitinh(int aGioitinh) {
        gioitinh = aGioitinh;
    }

    /**
     * Access method for chucvu.
     *
     * @return the current value of chucvu
     */
    public String getChucvu() {
        return chucvu;
    }

    /**
     * Setter method for chucvu.
     *
     * @param aChucvu the new value for chucvu
     */
    public void setChucvu(String aChucvu) {
        chucvu = aChucvu;
    }

    /**
     * Access method for taikhoan.
     *
     * @return the current value of taikhoan
     */
    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    /**
     * Setter method for taikhoan.
     *
     * @param aTaikhoan the new value for taikhoan
     */
    public void setTaikhoan(Taikhoan aTaikhoan) {
        taikhoan = aTaikhoan;
    }

    /**
     * Access method for phutrachTour.
     *
     * @return the current value of phutrachTour
     */
    public Set<PhutrachTour> getPhutrachTour() {
        return phutrachTour;
    }

    /**
     * Setter method for phutrachTour.
     *
     * @param aPhutrachTour the new value for phutrachTour
     */
    public void setPhutrachTour(Set<PhutrachTour> aPhutrachTour) {
        phutrachTour = aPhutrachTour;
    }

    /**
     * Compares the key for this instance with another Nhanvien.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Nhanvien and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Nhanvien)) {
            return false;
        }
        Nhanvien that = (Nhanvien) other;
        Object myManv = this.getManv();
        Object yourManv = that.getManv();
        if (myManv==null ? yourManv!=null : !myManv.equals(yourManv)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Nhanvien.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Nhanvien)) return false;
        return this.equalKeys(other) && ((Nhanvien)other).equalKeys(this);
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
        if (getManv() == null) {
            i = 0;
        } else {
            i = getManv().hashCode();
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
        StringBuffer sb = new StringBuffer("[Nhanvien |");
        sb.append(" manv=").append(getManv());
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
        ret.put("manv", getManv());
        return ret;
    }

}
