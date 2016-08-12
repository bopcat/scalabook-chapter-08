package prasalov

/**
 * Created by kirillp on 09.08.16.
 */
trait Prop {
  def check: Boolean
  def &&(p: Prop): Prop =
    if (check && p.check) new Prop {
      override def check: Boolean = true
    } else new Prop {
      override def check: Boolean = false
    }
}
