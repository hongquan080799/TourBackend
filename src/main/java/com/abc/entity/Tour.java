// Generated with g9.

package com.abc.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TOUR")
public class Tour{

    @Id
    @Column(name="MATOUR", unique=true, nullable=false, length=12)
    private String matour;
    @Column(name="TGBD")
    private LocalDateTime tgbd;
    @Column(name="TGKT")
    private LocalDateTime tgkt;
    @Column(name="GIATREEM", precision=53)
    private double giatreem;
    @Column(name="GIANGUOILON", precision=53)
    private double gianguoilon;
    
    @JsonIgnore
    @OneToMany(mappedBy="tour")
    private Set<Binhluan> binhluan;
    @JsonIgnore
    @OneToMany(mappedBy="tour")
    private Set<Danhgia> danhgia;
    @JsonIgnore
    @OneToMany(mappedBy="tour")
    private Set<Dattour> dattour;
    @JsonIgnore
    @OneToMany(mappedBy="tour")
    private Set<PhutrachTour> phutrachTour;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="MATUYEN")
    private Tuyen tuyen;

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

    public LocalDateTime getTgbd() {
        return tgbd;
    }

    /**
     * Setter method for tgbd.
     *
     * @param aTgbd the new value for tgbd
     */
    public void setTgbd(LocalDateTime aTgbd) {
        tgbd = aTgbd;
    }

    /**
     * Access method for tgkt.
     *
     * @return the current value of tgkt
     */
    public LocalDateTime getTgkt() {
        return tgkt;
    }

    /**
     * Setter method for tgkt.
     *
     * @param aTgkt the new value for tgkt
     */
    public void setTgkt(LocalDateTime aTgkt) {
        tgkt = aTgkt;
    }

    /**
     * Access method for giatreem.
     *
     * @return the current value of giatreem
     */
    public double getGiatreem() {
        return giatreem;
    }

    /**
     * Setter method for giatreem.
     *
     * @param aGiatreem the new value for giatreem
     */
    public void setGiatreem(double aGiatreem) {
        giatreem = aGiatreem;
    }

    /**
     * Access method for gianguoilon.
     *
     * @return the current value of gianguoilon
     */
    public double getGianguoilon() {
        return gianguoilon;
    }

    /**
     * Setter method for gianguoilon.
     *
     * @param aGianguoilon the new value for gianguoilon
     */
    public void setGianguoilon(double aGianguoilon) {
        gianguoilon = aGianguoilon;
    }


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

    

}
