package algorithm.sort;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/22 15:57
 * 冒泡排序
 * 基本逻辑
 * 每一轮进行一次遍历，元素两两比较，大(小)的元素不断往后移动
 * 这样每轮都会确定一个元素的位置
 * 一共需要n-1轮
 *
 * 复杂度O(n^2)
 * 是稳定的排序算法
 *
 * 优化一:如果每一轮中没有发生元素的交换，那就说明整个数组已经排序好了，直接返回
 *
 */

public class BubbleSort {
    public static void main(String[] args) {

    }

    public static int[] BubbleSort1(int[] a){
        boolean flage=false;
        for (int i=0;i<a.length;i++){
           if (!flage)
               return a;
            for (int j=0;j<a.length-i;j++){
                if (a[j]<a[i]){
                    flage=true;
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                }
            }
        }
        return a;
    }
}
