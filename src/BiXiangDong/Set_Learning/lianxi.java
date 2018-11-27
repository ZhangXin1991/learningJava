package BiXiangDong.Set_Learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


/*
* 练习:   Collection集合框架应用
* */
public class lianxi {
    public static void main(String[] args) {
        RongQi rongQi = new RongQi();
        rongQi.rqadd("b旺财");
        rongQi.rqadd("a来福");
        rongQi.rqadd("c赵毅");
        rongQi.rqadd("e范英博");
        rongQi.rqadd("q张欣");
//        rongQi.rqsort();
//        rongQi.rqsort("f");
        rongQi.rqsort1(new ComparetorByRongQiToReverse());
        for (Iterator iterator = rongQi.getArrayList().iterator();
             iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}


class RongQi implements compare<Comparator>{

    private ArrayList arrayList;

    public RongQi() {
        this.arrayList = new ArrayList();
    }

    public ArrayList getArrayList() {
        return arrayList;
    }
//    public void setArrayList(ArrayList arrayList) {
//        this.arrayList = arrayList;
//    }

    public void rqadd(Object object) {
        arrayList.add(object);
    }

    public Object rqremove(Object object) {
        return arrayList.remove(object);
    }

    @Override
    public String toString() {
        return getArrayList().toString();
    }

    public void rqsort() {
        arrayList.sort(new ComparetorByRongQi());
    }

    public void rqsort(String s) {
        if (s.equals("z")) {
            arrayList.sort(new ComparetorByRongQi());
        }
        if (s.equals("f")) {
            arrayList.sort(new ComparetorByRongQiToReverse());
        }
    }

    @Override
    public void rqsort1(Comparator comparator) {
        arrayList.sort(comparator);
    }
}

interface compare<Comparator> {
    public void rqsort1(Comparator comparator);
}

class ComparetorByRongQi implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int temp = o1.compareTo(o2);

        return temp ==0? o1.hashCode()-o2.hashCode():temp;
    }
}

class ComparetorByRongQiToReverse implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int temp = o1.compareTo(o2);

//        return temp ==0? o1.hashCode()-o2.hashCode(): temp;
        return temp ==0? o1.hashCode()-o2.hashCode(): temp*-1;
    }
}
