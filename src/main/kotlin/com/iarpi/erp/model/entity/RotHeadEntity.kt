package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.RouteEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPROTHEAD")
data class RotHeadEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_head_sequence")
    @SequenceGenerator(name = "rot_head_sequence", sequenceName = "bsmgrirprothead_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "ROT_DOC_FROM", nullable = false)
    val rotDocFrom: LocalDate = LocalDate.now(),

    @Column(name = "ROT_DOC_UNTIL", nullable = false)
    val rotDocUntil: LocalDate = LocalDate.now(),

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
    @JoinColumn(name = "BOM_HEAD_ID", nullable = false)
    val bomHead: BomHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAT_HEAD_ID", nullable = false)
    val materialHead: MaterialHeadEntity
)
