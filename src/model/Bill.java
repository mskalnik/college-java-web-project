package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "bill", schema = "public", catalog = "java-simple-webshop")
public class Bill {
    private int billId;
    private Timestamp date;
    private BigDecimal price;
    private String note;
    private User userByUserId;
    private PaymentMethod paymentMethodByPaymentMethodId;
    private Article bill_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id", nullable = false)
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "note", nullable = true, length = 500)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return billId == bill.billId &&
                Objects.equals(date, bill.date) &&
                Objects.equals(price, bill.price) &&
                Objects.equals(note, bill.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billId, date, price, note);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id", nullable = false)
    public PaymentMethod getPaymentMethodByPaymentMethodId() {
        return paymentMethodByPaymentMethodId;
    }

    public void setPaymentMethodByPaymentMethodId(PaymentMethod paymentMethodByPaymentMethodId) {
        this.paymentMethodByPaymentMethodId = paymentMethodByPaymentMethodId;
    }

    @OneToOne(mappedBy = "billId")
    public Article getBill_id() {
        return bill_id;
    }

    public void setBill_id(Article bill_id) {
        this.bill_id = bill_id;
    }
}
