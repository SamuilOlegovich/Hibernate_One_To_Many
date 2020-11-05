package hibernate.model;

import lombok.*;

import javax.persistence.GenerationType;
import javax.persistence.*;
//import lombok.*;


@Data                               // анотация выполяет роль замены гетеров и сетерв
@ToString
@EqualsAndHashCode
@NoArgsConstructor                  // анотация заменяет обязательное присутствие пустого конструктора
@AllArgsConstructor                 // анотация заменяет присутствие конструктора c параметрами
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mark;
    private Integer cost;
}
