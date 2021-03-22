package com.klim.daggersample.data.repository.post.dataSources.remote

import com.klim.daggersample.data._retrofit.apis.feedback.PostPOJO
import com.klim.daggersample.data.repository.post.PostDTO

fun List<PostPOJO>.mapToDTO(): List<PostDTO> {
    return this.map { it.map() }
}

fun PostPOJO.map(): PostDTO {
    return PostDTO(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body,
    )
}