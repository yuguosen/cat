package leeCode.easy

/**
  * Created by yu on 2017/8/2.
  */

/**
  * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
  * *
  * Given two integers x and y, calculate the Hamming distance.
  * *
  * Note:
  * 0 ≤ x, y < 2 ^31.
  * *
  * Example:
  * *
  * Input: x = 1, y = 4
  * *
  * Output: 2
  * *
  * Explanation:
  * 1   (0 0 0 1)
  * 4   (0 1 0 0)
  * ?   ?
  * *
  * The above arrows point to positions where the corresponding bits are different.
  **/
object HammingDistance {
    def main(args: Array[String]): Unit = {
        "sss".toUpperCase
        val s1 = 1
        val s2 = 8
        val ss = s1 ^ s2
        println(ss.toBinaryString)
        println(s2 & (s2 - 1))
        println(hammingDistance(1,4))
    }

    def hammingDistance(x: Int, y: Int): Int = {
        var s = (x ^ y)
        var count = 0
        while (s > 0) {
            count += 1
            s = s & (s - 1)
        }
        return count
    }


}
