package com.nati.projeto.entities;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@MappedSuperclass
@Getter
@EqualsAndHashCode
public class EntidadeComUUID {
    @Id @Type(type = "pg-uuid")
    private UUID id;

    public EntidadeComUUID() {
        this.id = UUID.randomUUID();
    }
}
