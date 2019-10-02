package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "payment_method", schema = "public", catalog = "java-simple-webshop")
public class PaymentMethod {
    private int paymentMethodId;
    private String name;
    private Collection<Bill> billsByPaymentMethodId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
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
        PaymentMethod that = (PaymentMethod) o;
        return paymentMethodId == that.paymentMethodId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodId, name);
    }

    @OneToMany(mappedBy = "paymentMethodByPaymentMethodId")
    public Collection<Bill> getBillsByPaymentMethodId() {
        return billsByPaymentMethodId;
    }

    public void setBillsByPaymentMethodId(Collection<Bill> billsByPaymentMethodId) {
        this.billsByPaymentMethodId = billsByPaymentMethodId;
    }
}
