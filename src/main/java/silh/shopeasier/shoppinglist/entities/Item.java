package silh.shopeasier.shoppinglist.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "items",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(name = "item_type")
    private ItemType itemType;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    @JoinTable(name = "item_brand",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id"),
    uniqueConstraints = @UniqueConstraint(name = "item_brand_link", columnNames = {"item_id", "brand_id"}))
    private Set<Brand> brands;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(getId(), item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
