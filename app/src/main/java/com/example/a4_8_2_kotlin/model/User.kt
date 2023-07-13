package com.example.a4_8_2_kotlin.model

class User(var ism:String,var familya:String) :java.io.Serializable {

   public override fun toString(): String {
        return "User(ism='$ism', familya='$familya')"
    }

}