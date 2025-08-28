package com.app.finanzas.entity;

import com.app.finanzas.config.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idCategory", nullable = false)
    private Category category;

    @Column(name = "type", nullable = false, length = 50)
    private TransactionTypeEnum type;

    @Column(name = "ammount", nullable = false)
    private Double ammount;

    @CreationTimestamp
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "description", length = 255)
    private String description;
}
