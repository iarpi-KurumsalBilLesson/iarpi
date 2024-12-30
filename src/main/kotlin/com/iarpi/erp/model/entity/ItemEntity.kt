package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table
data class ItemEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_id_seq", allocationSize = 1)
    val id : Long
)
