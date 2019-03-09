package ch.tournamator.data

import org.springframework.data.annotation.Id

open class BaseEntity {
    @Id
    var id: String? = null
}