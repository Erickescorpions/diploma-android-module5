package com.erickvazquezs.hellomodulo4.practices.explicitIntent

import java.io.Serializable

data class Person(
    val name: String,
    val age: Int,
    val isGraduate: Boolean
): Serializable