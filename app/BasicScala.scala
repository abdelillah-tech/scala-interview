package com.particeep.test

/**
  * This is basic language questions so don't use external library or build in function
  */
object BasicScala {


  /**
    * Encode parameter in url format
    *
    * Example:
    *
    * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
    * output : "?sort_by=name&order_by=asc&user_id=12"
    *
    * input  : Map()
    * output : ""
    */
  def encodeParamsInUrl(params: Map[String, String]): String = {
    if(params.isEmpty) ""
    else{
      var khra:String = "?"
      for ((k,v) <- params) khra = khra + k + '=' + v + '&'
      khra.dropRight(1)
    }
  }


  /**
    * Test if a String is an email
    */
  def isEmail(maybeEmail: String): Boolean = {
    var a = 0;
    var b = 0;
    var c = 1;
    var d:Boolean = true;
    while(c < maybeEmail.length){
      if(maybeEmail(0) == '.' || maybeEmail(0) == ' ' || maybeEmail(0) == '@') return false;
      if(maybeEmail(c) == '.' && maybeEmail(c-1) == '.') return false;
      if(maybeEmail(c) == '@' && maybeEmail(c-1) == '.') return false;
      if(maybeEmail(c) == '.' && maybeEmail(c-1) == '@') return false;
      if(maybeEmail(maybeEmail.length - 1) == '.') return false;
      if(maybeEmail(c) == ' ') return false;
      if(maybeEmail(c) == '@' && d){
        a = c;
        d = false
      }else if(maybeEmail(c) == '@' && !d){
        return false;
      }
      if(maybeEmail(c) == '.') b = c;
      c = c + 1
    }
    if(b > a && b!=0 && a!=0) true else false;
  }

  /**
    * Compute i ^ n
    *
    * Example:
    *
    * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
    * output : 8
    *
    * input : (i = 99, n = 38997)
    * output : 1723793299
    */
  def power(i:Int, n:Int):Int = { 
    var N = i
    var M = n
    if(M == 0) return 1
    var recursive = power(N, M/2)
    if(M % 2 == 0) return recursive * recursive
    return recursive * recursive * N
  }


}
