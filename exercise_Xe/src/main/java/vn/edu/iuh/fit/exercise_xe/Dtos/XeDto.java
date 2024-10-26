package vn.edu.iuh.fit.exercise_xe.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vn.edu.iuh.fit.exercise_xe.Dtos.HangxeDto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link vn.edu.iuh.fit.exercise_xe.entities.Xe}
 */
public class XeDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    private String tenXe;
    private Double giaXe;
    private Integer namSX;
    @NotNull
    private HangxeDto maHangXe;

    public XeDto(Integer id, String tenXe, Double giaXe, Integer namSX, HangxeDto maHangXe) {
        this.id = id;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.maHangXe = maHangXe;
    }

    public XeDto(String tenXe, Double giaXe, Integer namSX, HangxeDto maHangXe) {
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.maHangXe = maHangXe;
    }

    public XeDto() {

    }

    public Integer getId() {
        return id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public Double getGiaXe() {
        return giaXe;
    }

    public Integer getNamSX() {
        return namSX;
    }

    public HangxeDto getMaHangXe() {
        return maHangXe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XeDto entity = (XeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tenXe, entity.tenXe) &&
                Objects.equals(this.giaXe, entity.giaXe) &&
                Objects.equals(this.namSX, entity.namSX) &&
                Objects.equals(this.maHangXe, entity.maHangXe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenXe, giaXe, namSX, maHangXe);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tenXe = " + tenXe + ", " +
                "giaXe = " + giaXe + ", " +
                "namSX = " + namSX + ", " +
                "maHangXe = " + maHangXe + ")";
    }
}