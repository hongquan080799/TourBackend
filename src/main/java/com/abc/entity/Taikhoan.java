// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TAIKHOAN")
public class Taikhoan implements Serializable {

    /** Primary key. */
    protected static final String PK = "username";

    @Id
    @Column(name="USERNAME", unique=true, nullable=false, length=50)
    private String username;
    @Column(name="PASSWORD", length=50)
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy="taikhoan")
    private List<Khachhang> listKH;
    @JsonIgnore
    @OneToMany(mappedBy="taikhoan")
    private List<Nhanvien> nhanvien;

    /** Default constructor. */
    public Taikhoan() {
        super();
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for khachhang.
     *
     * @return the current value of khachhang
     */
    

    /**
     * Compares the key for this instance with another Taikhoan.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Taikhoan and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Taikhoan)) {
            return false;
        }
        Taikhoan that = (Taikhoan) other;
        Object myUsername = this.getUsername();
        Object yourUsername = that.getUsername();
        if (myUsername==null ? yourUsername!=null : !myUsername.equals(yourUsername)) {
            return false;
        }
        return true;
    }

    public List<Khachhang> getListKH() {
		return listKH;
	}

	public void setListKH(List<Khachhang> listKH) {
		this.listKH = listKH;
	}

	public List<Nhanvien> getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(List<Nhanvien> nhanvien) {
		this.nhanvien = nhanvien;
	}

	public static String getPk() {
		return PK;
	}

	/**
     * Compares this instance with another Taikhoan.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Taikhoan)) return false;
        return this.equalKeys(other) && ((Taikhoan)other).equalKeys(this);
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
        if (getUsername() == null) {
            i = 0;
        } else {
            i = getUsername().hashCode();
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
        StringBuffer sb = new StringBuffer("[Taikhoan |");
        sb.append(" username=").append(getUsername());
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
        ret.put("username", getUsername());
        return ret;
    }

}
