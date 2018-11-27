package BiXiangDong.enum_Learning;

import org.junit.Test;

/**
 * 枚举 enum
 */
public class L02_enum {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        print(Grade.E);
    }


    public void print(Grade grade) {
        String value = grade.getValue();
        System.out.println(value);
        String value1 = grade.localeValue();
        System.out.println(value1);
    }

    @Test
    public void test2() {
        print2(WeekDay.SUN);
        WeekDay weekDays[] = WeekDay.values();
        for (WeekDay w : weekDays) {
            System.out.println(w);
        }
    }

    public void print2(WeekDay weekDay) {
        String weekday = weekDay.getValue();
        System.out.println(weekday);
        String weekday2 =weekDay.toChina();
        System.out.println(weekday2);
    }


}

//  如何定义枚举的构造方法,字段,去封装更多的数据
//  带抽象方法的枚举
enum Grade {
    //  成绩等级
    A("100-90"){
        public String localeValue() {
            return "优";
        }
    }
    , B("89-80"){
        public String localeValue() {
            return "良";
        }
    }
    , C("79-70"){
        public String localeValue() {
            return "一般";
        }
    }
    , D("69-60"){
        public String localeValue() {
            return "差";
        }
    }
    , E("59-0"){
        public String localeValue() {
            return "未及格";
        }
    };

    private String value;

    private Grade(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    //  定义抽象方法, 因此在类中一定实现该抽象方法
    public abstract String localeValue();

}

/**
 * 关于星期几的枚举WeekDay,要求:
 * 枚举值: MON,TUE,WED,THU,FRI,SAT,SUN
 * 该枚举要有一个方法,调用该方法返回中文格式的星期
 */
enum WeekDay {
    MON("MON"){
        @Override
        public String toChina() {
            return "星期一";
        }
    },TUE("TUE"){
        @Override
        public String toChina() {
            return "星期二";
        }
    },WED("WED"){
        @Override
        public String toChina() {
            return "星期三";
        }
    },THU("THU") {
        @Override
        public String toChina() {
            return "星期四";
        }
    },FRI("FRI") {
        @Override
        public String toChina() {
            return "星期五";
        }
    },SAT("SAT") {
        @Override
        public String toChina() {
            return "星期六";
        }
    },SUN("SUN") {
        @Override
        public String toChina() {
            return "星期日";
        }
    };
    private String value;
    private WeekDay(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }


    public abstract String toChina();
}