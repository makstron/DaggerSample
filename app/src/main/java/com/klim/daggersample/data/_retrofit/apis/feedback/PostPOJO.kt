package com.klim.daggersample.data._retrofit.apis.feedback

import com.fasterxml.jackson.annotation.JsonProperty

class PostPOJO(
    @JsonProperty("id") val id: Int,
    @JsonProperty("userId") val userId: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("body") val body: String,
)