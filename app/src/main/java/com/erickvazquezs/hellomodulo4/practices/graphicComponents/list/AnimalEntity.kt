package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list

import java.io.Serializable

data class AnimalEntity(
    val name: String,
    val color: String,
    val image: String
) : Serializable