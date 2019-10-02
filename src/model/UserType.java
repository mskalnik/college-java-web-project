package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_type", schema = "public", catalog = "java-simple-webshop")
public class UserType {
    private int userTypeId;
    private String name;
    private Collection<User> usersByUserTypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id", nullable = false)
    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserType userType = (UserType) o;
        return userTypeId == userType.userTypeId &&
                Objects.equals(name, userType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userTypeId, name);
    }

    @OneToMany(mappedBy = "userTypeByUserTypeId")
    public Collection<User> getUsersByUserTypeId() {
        return usersByUserTypeId;
    }

    public void setUsersByUserTypeId(Collection<User> usersByUserTypeId) {
        this.usersByUserTypeId = usersByUserTypeId;
    }
}
