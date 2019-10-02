package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int userId;
    private String email;
    private String password;
    private Collection<Bill> billsByUserId;
    private UserType userTypeByUserTypeId;
    private Collection<UserLog> userLogsByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 256)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Bill> getBillsByUserId() {
        return billsByUserId;
    }

    public void setBillsByUserId(Collection<Bill> billsByUserId) {
        this.billsByUserId = billsByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "user_type_id", referencedColumnName = "user_type_id", nullable = false)
    public UserType getUserTypeByUserTypeId() {
        return userTypeByUserTypeId;
    }

    public void setUserTypeByUserTypeId(UserType userTypeByUserTypeId) {
        this.userTypeByUserTypeId = userTypeByUserTypeId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserLog> getUserLogsByUserId() {
        return userLogsByUserId;
    }

    public void setUserLogsByUserId(Collection<UserLog> userLogsByUserId) {
        this.userLogsByUserId = userLogsByUserId;
    }
}
