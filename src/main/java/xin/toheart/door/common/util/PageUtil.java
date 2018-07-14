package xin.toheart.door.common.util;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PageUtil<T> {

    private int size = 10;//每页显示记录  默认为十
    private int index=1; //当前页号 默认为一
    private int totalPageCount =1;//总页数  默认为一
    private  int totalCount=1;//记录总数  默认为一

    private int[] numbers; //显示页数的集合
    protected List<T> list; //要显示到页面的数据集

    /**
     * 得到开始记录
     * @return
     */
    public int getStartRow(){
        return (index-1)*size;
    }

    /**
     * 得到结束记录
     * @return
     */
    public int getEndRow(){
        return index*size;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size>0){
            this.size = size;
        }
    }

    public int getIndex() {
        if(totalPageCount==0){
            return 0;
        }
        return index;
    }

    public void setIndex(int index) {
        if(index>0){
            this.index = index;
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            setTotalPageCountByRs();//根据总记录数计算总页数
        }
    }

    private void setTotalPageCountByRs() {
        if(this.size>0 && this.totalCount>0 && this.totalCount%this.size==0){
            this.totalPageCount=this.totalCount/this.size;
        }else if(this.size>0 && this.totalCount>0 && this.totalCount%this.size>0){
            this.totalPageCount=this.totalCount/this.size+1;
        } else {
            this.totalPageCount = 0;
        }
        setNumbers(totalPageCount);
    }
    public void setNumbers(int totalPageCount) {
        if(totalPageCount>0){
            //!.当前数组的长度
            int[] numbers = new int[totalPageCount>10?10:totalPageCount];//页面要显示的页数集合
            int k =0;
            //
            //1.数组长度<10   1 2 3 4 ....   7
            //2.数组长度>=10
            //     当前页<=6  1 2 3 4    10
            //     当前页>=总页数-5           ......12 13 14 15
            //     其他                                5  6  7 8   9 当前页(10)  10  11 12  13
            for(int i = 0;i < totalPageCount;i++){
                //保证当前页为集合的中�?
                if((i>=index- (numbers.length/2+1) || i >= totalPageCount-numbers.length) && k<numbers.length){
                    numbers[k] = i+1;
                    k++;
                }else if(k>=numbers.length){
                    break;
                }
            }

            this.numbers = numbers;
        }

    }
    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "size=" + size +
                ", index=" + index +
                ", totalPageCount=" + totalPageCount +
                ", totalCount=" + totalCount +
                ", numbers=" + Arrays.toString(numbers) +
                ", list=" + list +
                '}';
    }

    public static PageUtil getPageBean(String index, String size){
        int index2=1;
        if(index != null && !"".equals(index)){
            index2 = Integer.parseInt(index);
        }

        int size2 = 5;
        if(size != null && !"".equals(size)){
            size2 = Integer.parseInt(size);
        }

        PageUtil pageBean = new PageUtil();
        pageBean.setIndex(index2);
        pageBean.setSize(size2);
        return pageBean;
    }
}
