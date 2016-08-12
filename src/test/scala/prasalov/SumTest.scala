package prasalov

import org.scalacheck._
import scala.collection.immutable.List

/**
 * Created by kirillp on 05.08.16.
 */
object SumTest extends Properties("Sum") {

  import Prop.forAll
/*
  val intList = Gen.listOf(Gen.choose(0, 100))
  val intVal = Gen.choose(0, 1000)
  //val fixedValueList = {val List.fill(100)(Gen.choose(0, 100))}

  property("reversed sum equals the original one") = forAll(intList)(ns => ns.sum == ns.reverse.sum)
  property("sum of a list and a value equals sum of the list including the value") = forAll(intVal, intList)((n, ns) => n + ns.sum == (n :: ns).sum)
  property("sum of a list equals to sum of its parts") = forAll(intList)(ns => {
    val (left, right) = ns.splitAt(ns.length / 2)
    ns.sum == left.sum + right.sum
  })
*/
}
