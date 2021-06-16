// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name="NHAHANG")
public class Nhahang implements Serializable {

    /** Primary key. */
    protected static final String PK = "manh";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @Column(name="MANH", unique=true, nullable=false, length=12)
    private String manh;
    @Column(name="TENNH", length=200)
    private String tennh;
    @OneToMany(mappedBy="nhahang")
    private Set<Datnhahang> datnhahang;

    /** Default constructor. */
    public Nhahang() {
        super();
    }

    /**
     * Access method for manh.
     *
     * @return the current value of manh
     */
    public String getManh() {
        return manh;
    }

    /**
     * Setter method for manh.
     *
     * @param aManh the new value for manh
     */
    public void setManh(String aManh) {
        manh = aManh;
    }

    /**
     * Access method for tennh.
     *
     * @return the current value of tennh
     */
    public String getTennh() {
        return tennh;
    }

    /**
     * Setter method for tennh.
     *
     * @param aTennh the new value for tennh
     */
    public void setTennh(String aTennh) {
        tennh = aTennh;
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
     * Compares the key for this instance with another Nhahang.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Nhahang and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Nhahang)) {
            return false;
        }
        Nhahang that = (Nhahang) other;
        Object myManh = this.getManh();
        Object yourManh = that.getManh();
        if (myManh==null ? yourManh!=null : !myManh.equals(yourManh)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Nhahang.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Nhahang)) return false;
        return this.equalKeys(other) && ((Nhahang)other).equalKeys(this);
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
        if (getManh() == null) {
            i = 0;
        } else {
            i = getManh().hashCode();
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
        StringBuffer sb = new StringBuffer("[Nhahang |");
        sb.append(" manh=").append(getManh());
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
        ret.put("manh", getManh());
        return ret;
    }

}
