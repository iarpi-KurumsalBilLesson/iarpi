package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPBOMHEAD")
data class BomHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_head_sequence")
    @SequenceGenerator(name = "bom_head_sequence", sequenceName = "bsmgrirpbomhead_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "BOM_DOC_NUM", nullable = false, unique = true, length = 25)
    val docNum: String,

    @Column(name = "BOM_DOC_FROM", nullable = false)
    val bomDocFrom: LocalDate = LocalDate.now(),

    @Column(name = "BOM_DOC_UNTIL", nullable = false)
    val bomDocUntil: LocalDate = LocalDate.now(),

    @Column(name = "QUANTITY", nullable = false, precision = 5, scale = 2)
    val quantity: BigDecimal,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?,

    @Column(name = "DRAW_NUM", length = 25)
    val drawNum: String?,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAT_HEAD_ID", nullable = false)
    val materialHead: MaterialHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM_DOC_TYPE_ID", nullable = false)
    val bomType: BomEntity,

    @OneToMany(mappedBy = "bomHead", cascade = [CascadeType.ALL], orphanRemoval = true)
    val bomContents: MutableList<BomContentEntity> = mutableListOf()
)
