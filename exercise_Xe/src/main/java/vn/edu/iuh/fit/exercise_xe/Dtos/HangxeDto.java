package vn.edu.iuh.fit.exercise_xe.Dtos;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link vn.edu.iuh.fit.exercise_xe.entities.Hangxe}
 */
public class HangxeDto implements Serializable {
    private  Integer id;
    @Size(max = 50)
    private  String tenHang;
    @Size(max = 50)
    private  String quocGia;
    @Size(max = 50)
    private  String moTa;

    public HangxeDto(Integer id, String tenHang, String quocGia, String moTa) {
        this.id = id;
        this.tenHang = tenHang;
        this.quocGia = quocGia;
        this.moTa = moTa;
    }

    public HangxeDto(Integer id, String tenHang) {
    }

    public Integer getId() {
        return id;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public String getMoTa() {
        return moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HangxeDto entity = (HangxeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tenHang, entity.tenHang) &&
                Objects.equals(this.quocGia, entity.quocGia) &&
                Objects.equals(this.moTa, entity.moTa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenHang, quocGia, moTa);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tenHang = " + tenHang + ", " +
                "quocGia = " + quocGia + ", " +
                "moTa = " + moTa + ")";
    }
}