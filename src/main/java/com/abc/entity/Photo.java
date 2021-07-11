// Generated with g9.

package com.abc.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="PHOTO")
public class Photo implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="PICTURE", length=200)
    private String picture;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="MATUYEN")
    private Tuyen tuyen;

    /** Default constructor. */
    public Photo() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for picture.
     *
     * @return the current value of picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Setter method for picture.
     *
     * @param aPicture the new value for picture
     */
    public void setPicture(String aPicture) {
        picture = aPicture;
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

    /**
     * Compares the key for this instance with another Photo.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Photo and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Photo)) {
            return false;
        }
        Photo that = (Photo) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Photo.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Photo)) return false;
        return this.equalKeys(other) && ((Photo)other).equalKeys(this);
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
        i = getId();
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
        StringBuffer sb = new StringBuffer("[Photo |");
        sb.append(" id=").append(getId());
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
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
