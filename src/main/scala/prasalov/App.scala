package prasalov

import java.util.concurrent._

/**
 * Created by kirillprasalov on 07.04.16.
 */
object App {

  implicit class MyFunnyClass(s: String) {
    def printToConsole = println(s)
    def splitIntoChars = s.toList
  }

  def main(args: Array[String]): Unit = {
    val s: String = "FOO" // a plain old java.lang.String
    s.printToConsole // prints 'FOO' 
    println(s.splitIntoChars) // prints 'List(F, O, O)'
  }
}

