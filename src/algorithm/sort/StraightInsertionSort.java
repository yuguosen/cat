package algorithm.sort;

/**
 * Created by ygs on 2017/6/6.
 * email：yuguosen@baiqishi.com
 * 404625710@qq.com
 * company:深圳白骑士大数据有限公司
 */

public class StraightInsertionSort {
    public static void main(String[] args) {
        int[] a={1,3,3,0,9,34,1,4,6};
        a=sort(a);
        for (int num:a)
            System.out.println(num);
    }

    public static int[] sort(int[] array){
        if(array==null||array.length<2)
            return null;
        for (int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                int insertNum=array[i];
                int insertIndex=i-1;
                for(int j=i-1;j>=0;j--){
                    if(insertNum<array[j]){
                        array[j+1]=array[j];
                        insertIndex--;
                    }
                }
                array[insertIndex+1]=insertNum;
            }

        }
        return array;
    }
}