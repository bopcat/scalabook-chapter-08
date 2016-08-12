package prasalov

/**
 * Created by kirillp on 11.08.16.
 */
case class Gen[A](sample: State[RNG, A]) {

  def map[A,B](f: A => B): Gen[B] = ???

  def flatMap[B](f: A => Gen[B]): Gen[B] = Gen(
    State(
      rng => {
        val (a, newRng) = sample.run(rng)
        f(a).sample.run(newRng)
      }
    )
  )

  def listOfN(size: Gen[Int]): Gen[List[A]] = size.flatMap(Gen.listOfN(_, this))

}


object Gen {
/*
  // another way to implement this is probably subclass RNG
  def choose(start: Int, stopExclusive: Int): Gen[Int] = new Gen(
    new State[RNG, Int](
      rng => {
        val (result, newRng) = rng.nextInt
        // todo handle the case when stopExclusive - start is not a divisor of Integer.MAX_VALUE
        (start + result % (stopExclusive - start), newRng)
      }
    )
  )
*/

  def choose(start: Int, stopExclusive: Int): Gen[Int] = Gen(State(RNG.nonNegativeInt))
  def unit[A](a: => A): Gen[A] = new Gen(new State[RNG, A](rng => (a, rng)))
  def boolean: Gen[Boolean] = Gen(State(RNG.boolean))
  def listOfN[A](n: Int, g: Gen[A]): Gen[List[A]] = Gen(
    State(
      rng =>
        (1 to n).foldLeft((Nil: List[A], rng))((cur, _) => {
          val (newA, newRng) = g.sample.run(cur._2)
          (cur._1 :+ newA, newRng)
        })
    )
  )
  def union[A](g1: Gen[A], g2: Gen[A]): Gen[A] = boolean.flatMap(if (_) g1 else g2)
  def weighted[A](g1: (Gen[A], Double), g2: (Gen[A], Double)): Gen[A] = choose(0, Int.MaxValue)
                        .flatMap(i => if (i < Int.MaxValue * g1._2/(g1._2 + g2._2)) g1._1 else g2._1)
}
