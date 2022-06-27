package com.prgms.kokoahairshop.menu.entity;

import com.prgms.kokoahairshop.hairshop.entity.Hairshop;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.DayOfWeek;

@Entity
@Getter
@Table(name = "hairshop")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // https://erjuer.tistory.com/106
public class Menu extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    @Column(name = "name", nullable = false, columnDefinition = "varchar(30)")
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "discount", nullable = false)
    private Integer discount;

    @Column(name = "gender", nullable = false, columnDefinition = "char(1)")
    private String gender;

    @Column(name = "type", nullable = false, columnDefinition = "char(1)")
    private String type;

    @Column(name = "exposed_time", nullable = false)
    private Integer exposed_time;

    @Size(max = 200)
    @Column(name = "image", nullable = true, columnDefinition = "varchar(200)")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hairshop_id", referencedColumnName = "id")
    private Hairshop hairshop;

    @Builder(toBuilder = true)
    public Menu(Long id, String name, Integer price, Integer discount, String gender,
                String type, Integer exposed_time, String image, Hairshop hairshop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.gender = gender;
        this.type = type;
        this.exposed_time = exposed_time;
        this.image = image;
        this.hairshop = hairshop;
    }
}
