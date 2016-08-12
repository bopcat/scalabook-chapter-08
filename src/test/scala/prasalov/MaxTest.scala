package prasalov

import org.scalacheck._

/**
 * Created by kirillp on 05.08.16.
 */
object MaxTest extends Properties("Max") {

  import Prop.forAll

  val intList = org.scalacheck.Gen.listOf(Gen.choose(0, 100))
  val intVal = org.scalacheck.Gen.choose(0, 1000)

  //property("Max of lists is the same as max of combined list") = forAll(intList, intList)((ns1, ns2) => Math.max(ns1.max, ns2.max) == (ns1 ::: ns2).max)

}
