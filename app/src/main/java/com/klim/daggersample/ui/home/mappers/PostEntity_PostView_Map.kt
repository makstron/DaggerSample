package com.klim.daggersample.ui.home.mappers

import com.klim.daggersample.domain.entity.PostEntity
import com.klim.daggersample.ui.home.viewEntity.PostView

fun List<PostEntity>.mapToPostView(): List<PostView> {
    return this.map { it.map() }
}

fun PostEntity.map(): PostView {
    return PostView(
        id = this.id,
        title = this.title,
        body = this.body,
    )
}