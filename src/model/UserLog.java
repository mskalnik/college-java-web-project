package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_log", schema = "public", catalog = "java-simple-webshop")
public class UserLog {
    private int userLogId;
    private String ipAddress;
    private Timestamp time;
    private User userByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_log_id", nullable = false)
    public int getUserLogId() {
        return userLogId;
    }

    public void setUserLogId(int userLogId) {
        this.userLogId = userLogId;
    }

    @Basic
    @Column(name = "ip_address", nullable = false, length = 15)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLog userLog = (UserLog) o;
        return userLogId == userLog.userLogId &&
                Objects.equals(ipAddress, userLog.ipAddress) &&
                Objects.equals(time, userLog.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLogId, ipAddress, time);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
