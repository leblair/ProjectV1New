package domain.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
//corresponde a :
@Table(name="anime")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeid;

    public String text;
    public String description;
    public String type;
    public int year;
    public String image;
}
