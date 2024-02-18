package com.mehmetgenc.bank.general;


import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Embedded
    private BaseAdditionalFields baseAdditionalFields;

}
