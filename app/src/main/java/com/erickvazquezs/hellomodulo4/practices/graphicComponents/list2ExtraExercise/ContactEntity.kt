package com.erickvazquezs.hellomodulo4.practices.graphicComponents.list2ExtraExercise

import java.io.Serializable

data class ContactEntity (
    val name: String,
    val phoneNumber: String,
    val photo: Int?
) : Serializable