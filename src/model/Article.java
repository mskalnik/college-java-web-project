package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "article", schema = "public", catalog = "java-simple-webshop")
public class Article {
    private int articleId;
    private int count;
    private BigDecimal price;
    private Bill billId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return articleId == article.articleId &&
                count == article.count &&
                Objects.equals(price, article.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, count, price);
    }

    @OneToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id", nullable = false)
    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }
}
