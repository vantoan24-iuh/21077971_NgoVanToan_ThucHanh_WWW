package vn.edu.iuh.fit.exercise_xe.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hangxe")
@NamedQueries({
        @NamedQuery(name = "Hangxe.findAll", query = "select h from Hangxe h"),
        @NamedQuery(name = "Hangxe.findById", query = "select h from Hangxe h where h.id = :id")
})

public class Hangxe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHangXe", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TenHang", length = 50)
    private String tenHang;

    @Size(max = 50)
    @Column(name = "QuocGia", length = 50)
    private String quocGia;

    @Size(max = 50)
    @Column(name = "MoTa", length = 50)
    private String moTa;

    public Hangxe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Hangxe{" +
                "id=" + id +
                ", tenHang='" + tenHang + '\'' +
                ", quocGia='" + quocGia + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hangxe hangxe = (Hangxe) o;
        return Objects.equals(id, hangxe.id) && Objects.equals(tenHang, hangxe.tenHang) && Objects.equals(quocGia, hangxe.quocGia) && Objects.equals(moTa, hangxe.moTa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenHang, quocGia, moTa);
    }
}