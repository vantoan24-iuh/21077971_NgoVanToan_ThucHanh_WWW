package vn.edu.iuh.fit.exercise_xe.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "xe")
@NamedQueries({
        @NamedQuery(name = "Xe.findAllXe", query = "select x from Xe x"),
        @NamedQuery(name = "Xe.findById", query = "select x from Xe x where x.id = :id"),
        @NamedQuery(name = "Xe.findByTenXe", query = "select x from Xe x where x.tenXe = :tenXe"),
        @NamedQuery(name = "Xe.findByGiaXe", query = "select x from Xe x where x.giaXe = :giaXe")
})
public class Xe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaXe", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TenXe", length = 50)
    private String tenXe;

    @Column(name = "GiaXe")
    private Double giaXe;

    @Column(name = "NamSX")
    private Integer namSX;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MaHangXe")
    private Hangxe maHangXe;

    public Xe(String trim, double giaXeValue, int namSXValue, Hangxe maHangXeDto) {
    }

    public Xe() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public Double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(Double giaXe) {
        this.giaXe = giaXe;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public void setNamSX(Integer namSX) {
        this.namSX = namSX;
    }

    public Hangxe getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(Hangxe maHangXe) {
        this.maHangXe = maHangXe;
    }

    @Override
    public String toString() {
        return "Xe{" +
                "id=" + id +
                ", tenXe='" + tenXe + '\'' +
                ", giaXe=" + giaXe +
                ", namSX=" + namSX +
                ", maHangXe=" + maHangXe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Xe xe = (Xe) o;
        return Objects.equals(id, xe.id) && Objects.equals(tenXe, xe.tenXe) && Objects.equals(giaXe, xe.giaXe) && Objects.equals(namSX, xe.namSX) && Objects.equals(maHangXe, xe.maHangXe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenXe, giaXe, namSX, maHangXe);
    }
}