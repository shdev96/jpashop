package jpabook.jpashop.entity.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("B")
public class Book extends Item{

    private String author;
    private String isbn;
}
