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

@Entity(name="KHACHHANG")
public class Khachhang implements Serializable {

    /** Primary key. */
    protected static final String PK = "cmnd";

    @Id
    @Column(name="CMND", unique=true, nullable=false, length=12)
    private String cmnd;
    @Column(name="TENKH", length=100)
    private String tenkh;
    @Column(name="SDT", length=12)
    private String sdt;
    @Column(name="DIACHI", length=200)
    private String diachi;
    @Column(name="EMAIL", length=200)
    private String email;
    @Column(name="GIOITINH", precision=10)
    private int gioitinh;
    @OneToMany(mappedBy="khachhang")
    private Set<Binhluan> binhluan;
    @OneToMany(mappedBy="khachhang")
    private Set<CtDattour> ctDattour;
    @OneToMany(mappedBy="khachhang")
    private Set<Danhgia> danhgia;
    @OneToMany(mappedBy="khachhang")
    private Set<Dattour> dattour;
    @ManyToOne
    @JoinColumn(name="USERNAME")
    private Taikhoan taikhoan;

    /** Default constructor. */
    public Khachhang() {
        super();
    }

    /**
     * Access method for cmnd.
     *
     * @return the current value of cmnd
     */
    public String getCmnd() {
        return cmnd;
    }

    /**
     * Setter method for cmnd.
     *
     * @param aCmnd the new value for cmnd
     */
    public void setCmnd(String aCmnd) {
        cmnd = aCmnd;
    }

    /**
     * Access method for tenkh.
     *
     * @return the current value of tenkh
     */
    public String getTenkh() {
        return tenkh;
    }

    /**
     * Setter method for tenkh.
     *
     * @param aTenkh the new value for tenkh
     */
    public void setTenkh(String aTenkh) {
        tenkh = aTenkh;
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
     * Access method for binhluan.
     *
     * @return the current value of binhluan
     */
    public Set<Binhluan> getBinhluan() {
        return binhluan;
    }

    /**
     * Setter method for binhluan.
     *
     * @param aBinhluan the new value for binhluan
     */
    public void setBinhluan(Set<Binhluan> aBinhluan) {
        binhluan = aBinhluan;
    }

    /**
     * Access method for ctDattour.
     *
     * @return the current value of ctDattour
     */
    public Set<CtDattour> getCtDattour() {
        return ctDattour;
    }

    /**
     * Setter method for ctDattour.
     *
     * @param aCtDattour the new value for ctDattour
     */
    public void setCtDattour(Set<CtDattour> aCtDattour) {
        ctDattour = aCtDattour;
    }

    /**
     * Access method for danhgia.
     *
     * @return the current value of danhgia
     */
    public Set<Danhgia> getDanhgia() {
        return danhgia;
    }

    /**
     * Setter method for danhgia.
     *
     * @param aDanhgia the new value for danhgia
     */
    public void setDanhgia(Set<Danhgia> aDanhgia) {
        danhgia = aDanhgia;
    }

    /**
     * Access method for dattour.
     *
     * @return the current value of dattour
     */
    public Set<Dattour> getDattour() {
        return dattour;
    }

    /**
     * Setter method for dattour.
     *
     * @param aDattour the new value for dattour
     */
    public void setDattour(Set<Dattour> aDattour) {
        dattour = aDattour;
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
     * Compares the key for this instance with another Khachhang.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Khachhang and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Khachhang)) {
            return false;
        }
        Khachhang that = (Khachhang) other;
        Object myCmnd = this.getCmnd();
        Object yourCmnd = that.getCmnd();
        if (myCmnd==null ? yourCmnd!=null : !myCmnd.equals(yourCmnd)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Khachhang.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Khachhang)) return false;
        return this.equalKeys(other) && ((Khachhang)other).equalKeys(this);
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
        if (getCmnd() == null) {
            i = 0;
        } else {
            i = getCmnd().hashCode();
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
        StringBuffer sb = new StringBuffer("[Khachhang |");
        sb.append(" cmnd=").append(getCmnd());
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
        ret.put("cmnd", getCmnd());
        return ret;
    }

}
