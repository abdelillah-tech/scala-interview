package com.particeep.test

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
    override val support: String = s"Ici c'est $city !"
  }
  
  Supporter.city //What does this print ? "Paris"
  Supporter.support //What does this print and why ? How to fix it ? "Ici c'est null" because we didn't overide "support" we can fix it by overriding "support" inside Sypporter Object
}
