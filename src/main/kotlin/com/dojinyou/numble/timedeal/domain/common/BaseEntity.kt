package com.dojinyou.numble.timedeal.domain.common

import com.dojinyou.numble.timedeal.global.utils.TimeUtils
import com.github.f4b6a3.ulid.UlidCreator
import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Persistable
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity: Persistable<UUID> {

    @Id
    private val id: UUID = UlidCreator.getMonotonicUlid().toUuid()

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: Instant = TimeUtils.now()
        protected set

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: Instant = TimeUtils.now()
        protected set

    @Transient
    private var _isNew = true

    override fun getId(): UUID = id

    override fun isNew(): Boolean = _isNew

    override fun equals(other: Any?): Boolean {
        return if (other == null) {
            false
        } else if ((other is HibernateProxy).not() && this::class != other::class) {
            false
        } else {
            id == getIdentifier(other)
        }
    }

    private fun getIdentifier(obj: Any): UUID {
        return if (obj is HibernateProxy) {
            (obj.hibernateLazyInitializer.identifier) as UUID
        } else {
            (obj as BaseEntity).id
        }
    }

    override fun hashCode() = Objects.hashCode(id)

    @PostPersist
    @PostLoad
    protected fun load() {
        _isNew = false
    }

    @PreUpdate
    fun preUpdate() {
        val now = TimeUtils.now()

        updatedAt = now
    }
}
