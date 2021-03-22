package com.klim.daggersample.data.repository.mappers

import com.klim.daggersample.domain.entity.PostEntity
import com.klim.daggersample.data.repository.post.PostDTO

fun List<PostDTO>.mapToEntity(): List<PostEntity> {
    return this.map {
        it.map()
    }
}

fun PostDTO.map(): PostEntity {
    return PostEntity(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body,
    )
}