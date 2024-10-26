package vn.edu.iuh.fit.exercise.backend.dots;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link vn.edu.iuh.fit.exercise.backend.repositories.entities.Loaithuoc}
 */
public class LoaithuocDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    private final String tenLoai;

    public LoaithuocDto(Integer id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
    }

    public Integer getId() {
        return id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoaithuocDto entity = (LoaithuocDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.tenLoai, entity.tenLoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenLoai);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "tenLoai = " + tenLoai + ")";
    }
}