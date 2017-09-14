package code

class Divs {

  def byConstFromObj(i: Int) = i / Consts.base

  def byConstLocal(i: Int) = i / 64

  def byShift(i: Int) = i >> 6

  def main(args: Array[String]): Unit = {
    byConstFromObj(1000)
    byConstLocal(1000)
  }
}
