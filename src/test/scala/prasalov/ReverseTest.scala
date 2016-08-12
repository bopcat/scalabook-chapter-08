package prasalov

import org.scalacheck._

/**
 * Created by kirillp on 05.08.16.
 */
object ReverseTest extends Properties("reverse") {

  import Prop.forAll
/*
  val intList = Gen.listOf(Gen.choose(0, 100))

  val prop =
        forAll(intList)(ns => ns.reverse.reverse == ns) &&
        forAll(intList)(ns => ns.headOption == ns.reverse.lastOption)
  val failingProp =
        forAll(intList)(ns => ns == ns.reverse)

  property("reverse works") = prop
  //property("reverse doesn't work incorrectly") = failingProp
*/
}
