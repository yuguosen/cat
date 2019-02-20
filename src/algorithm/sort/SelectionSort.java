package algorithm.sort;

/**
 * @author yuguosen@baiqishi.com
 * @date 2018/8/22 15:38
 *
 * 选择排序
 * 基本逻辑
 *  遍历数组，遍历到i的时候，0-i-1之间的数据值有序的，
 *  在i-n之间选择出最大(小)的，如果这个最大(小)得位置不是i，则交换位置
 *
 *  复杂度是 O(n^2)，最好最好平均都是
 *  是稳定的排序算法
 */

public class SelectionSort {
    public static void main(String[] args) {
        int [] a=new int[]{1,4,5,11,2,1,3,4,54,6};
        a=selectionSortDesc(a);
        for (int aa:a)
            System.out.println(aa);
        a=selectionSortAsc(a);
        for (int aa:a)
            System.out.println(aa);
    }
    public static int[] selectionSortDesc(int[] a){
        for (int i=0;i<a.length;i++){
            int pos=i;
            for (int j=i+1;j<a.length;j++){
                if (a[j] >a[pos])
                    pos=j;
            }
            if (pos!=i){
                int tmp=a[pos];
                a[pos]=a[i];
                a[i]=tmp;
            }
        }
        return a;
    }
    public  static int[] selectionSortAsc(int[] a){
        for (int i=0;i<a.length;i++){
            int pos=i;
            for (int j=i+1;j<a.length;j++){
                if(a[pos]>a[j])
                    pos=j;
            }
            if (pos!=i){
                int tmp=a[i];
                a[i]=a[pos];
                a[pos]=tmp;
            }
        }
        return a;
    }
}
