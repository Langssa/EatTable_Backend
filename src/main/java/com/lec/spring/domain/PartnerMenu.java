package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PartnerMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    @JoinColumn(name = "partnerId")
    private Partner partner;

    @PrePersist
    public void prePersist (){
        this.regDate = LocalDateTime.now();
    }

    @OneToOne
    @JoinColumn(name = "attachment_id") // DB에서 해당 컬럼명을 지정
    private PartnerMenuAttachment attachment;

}