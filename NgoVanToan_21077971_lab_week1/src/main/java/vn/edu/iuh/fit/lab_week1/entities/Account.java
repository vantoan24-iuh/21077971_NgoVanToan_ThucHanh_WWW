package vn.edu.iuh.fit.lab_week1.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(
                name = "Account.findAccountByIdPassword",
                query = "select a from Account a where a.accountId = :accountId and a.password = :password"
        ),
        @NamedQuery(
                name = "Account.findAccountsByRole",
                query = "select a from Account a join GrantAccess ga on a.accountId = ga.id.accountId where ga.id.roleId = :roleId"
        ),
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.findByAccountIdOrderByAccountIdAsc", query = "select a from Account a where a.accountId = :accountId order by a.accountId asc")
})
public class Account {
    @Id
    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    private Byte status;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

}