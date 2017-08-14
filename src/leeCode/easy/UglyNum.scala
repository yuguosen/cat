package leeCode.easy

/**
  * Created by yu on 2017/8/14.
  */
object UglyNum {
    def main(args: Array[String]): Unit = {
        for (i <- 2 to 100) {
            println(i + "->" + isUgly(i))
        }
    }

    def isUgly(num: Int): Boolean = {
        if(num<=0)
            return false
        if (num == 1)
            return true
        var n = num
        val set = Set[Int](2, 3, 5)
        set.foreach(x => {
            while (n % x == 0 && n > 0)
                n /= x
        })
        n == 1

    }
}
