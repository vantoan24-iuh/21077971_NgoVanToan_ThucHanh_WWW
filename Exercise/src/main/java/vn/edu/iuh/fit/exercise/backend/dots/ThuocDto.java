package vn.edu.iuh.fit.exercise.backend.dots;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vn.edu.iuh.fit.exercise.backend.repositories.entities.Thuoc;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Thuoc}
 */
public class ThuocDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    private final String tenThuoc;
    private final Double gia;
    private final Integer namSX;
    @NotNull
    private final LoaithuocDto maLoai;

    public ThuocDto(Integer id, String tenThuoc, Double gia, Integer namSX, LoaithuocDto maLoai) {
        this.id = id;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSX = namSX;
        this.maLoai = maLoai;
    }

    public Integer getId() {
        return id;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public Double getGia() {
        return gia;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public LoaithuocDto getMaLoai() {
        return maLoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThuocDto entity = (ThuocDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tenThuoc, entity.tenThuoc) &&
                Objects.equals(this.gia, entity.gia) &&
                Objects.equals(this.namSX, entity.namSX) &&
                Objects.equals(this.maLoai, entity.maLoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenThuoc, gia, namSX, maLoai);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tenThuoc = " + tenThuoc + ", " +
                "gia = " + gia + ", " +
                "namSX = " + namSX + ", " +
                "maLoai = " + maLoai + ")";
    }
}