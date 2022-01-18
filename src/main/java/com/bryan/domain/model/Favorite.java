package com.bryan.domain.model;

import com.bryan.domain.model.compositekeys.ClaveAnimeidUserid;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="favorite")
@IdClass(ClaveAnimeidUserid.class)
public class Favorite {

    @Id
    public UUID userid;

    @Id
    public UUID animeid;
}
