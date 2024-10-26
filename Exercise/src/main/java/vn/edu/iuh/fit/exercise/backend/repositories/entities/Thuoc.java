package vn.edu.iuh.fit.exercise.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Year;

@Entity
@Table(name = "thuoc")
@NamedQueries({
        @NamedQuery(name = "Thuoc.findALl", query = "select t from Thuoc t"),
        @NamedQuery(name = "Loaithuoc.findThuocByLoaiThuoc", query = "SELECT t FROM Thuoc t WHERE t.maLoai.id = :id")
})
public class Thuoc implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThuoc", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TenThuoc", length = 50)
    private String tenThuoc;

    @Column(name = "Gia")
    private Double gia;

    @Column(name = "NamSX")
    private Integer namSX;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MaLoai")
    private Loaithuoc maLoai;

    public Thuoc(String tenThuoc, double gia, int namSX, Loaithuoc loaiThuoc) {
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSX = namSX;
        this.maLoai = loaiThuoc;
    }

    public Thuoc() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public Loaithuoc getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loaithuoc maLoai) {
        this.maLoai = maLoai;
    }

}