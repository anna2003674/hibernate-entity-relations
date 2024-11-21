package org.example.one_to_many.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String item_name;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item(String itemName, Person owner) {
        this.item_name = itemName;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + id +
            ", item_name='" + item_name + '\'' +
            '}';
    }
}
