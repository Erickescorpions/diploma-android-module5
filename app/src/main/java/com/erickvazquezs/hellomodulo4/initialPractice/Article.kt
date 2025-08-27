package com.erickvazquezs.hellomodulo4.initialPractice

import java.io.Serializable

data class Article(
    val name: String,
    val price: Float,
    val quantity: Int,
    val available: Boolean,
    val imageId: Int
): Serializable
