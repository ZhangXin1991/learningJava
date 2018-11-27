package BiXiangDong.GUI_Learning;



import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * GUI  图形用户接口      Graphical User Interface
 *  用图形的方式, 来显示计算机操作的界面, 这样更方便更直观
 *
 * CLI  命令行用户接口    Command line User Interface
 *  就是常见的Dos命令行操作.
 *  需要记忆一些常用的命令, 操作不直观
 *
 *Java为GUI提供的对象都存在java.Awt和javax.Swing两个包中
 *  -   java.awt    抽象窗口工具包     Abstract Window ToolKit
 *          需要调用本地系统方法实现功能, 属重量级控件
 *  -   javax.swing
 *          在Awt的基础上, 建立的一套图形界面系统,
 *          其中提供了更多的组件, 而且完全由Java实现.
 *          增强了移植性, 属轻量级控件
 */

/**
 * awt的继承关系:
 *  Component   组件
 *      - Container 容器
 *        这是一个特殊的组件, 该组件中可以通过add方法添加其它组件
 *          |- Panel    面板, 平板
 *          |- Window   窗口
 *              |= Frame   框架, 窗体
 *              |= Dialog  对话框
 *                  ||- FileDialog  文件对话框
 *
 *      - Button    按钮
 *      - Label     标签
 *      - Checkbox  复选框, 多选框
 *      - TextComponent 文本组件
 *          |- TextArea     多行文本输入框, 文本区域(多行
 *          |- TextField    文本输入框, 文本框(单行
 */

/**
 * 布局管理器:
 *   容器中的组件的排放方式, 就是布局
 *   常见的布局管理器:
 *      |- FlowLayout    (流式布局管理器)
 *          - 从左到右的顺序排列
 *          - Panel(面板)默认的布局管理器
 *      |- BorderLayout  (边界布局管理器)
 *          - 东, 西, 南, 北, 中
 *          - Frame默认的布局管理器
 *      |- GridLayout    (网络布局管理器)
 *          - 规则的矩阵
 *      |- CardLayout    (卡片布局管理器)
 *          - 选项卡
 *      |- GridBagLayout (网络包布局管理器)
 *          - 非规则的矩阵
 */

/**
 * java.awt.event
 * 事件监听机制组成
 *      - 事件源(组件)
 *      - 事件 (Event)
 *      - 监听器(Listener)
 *      - 事件处理器(引发事件后处理方式)
 */
public class GUI_Learning_0_Frame {
    public static void main(String[] args) {
        /**
         * 构造Frame容器与button组件
         */
        Frame frame = new Frame("我是个标题吖!");
        Component_Frame_Demo(frame);
        //  添加输入框
        Component_TextArea_Demo(frame);
        /**
         * 事件监听机制组成
         */
        Event_Listener(frame);
    }

    /**
     * 1, 构造窗体
     * 2, 构造组件
     * 3, 将组件添加到窗体中
     * 4, 将窗体设置为可见的
     * @param frame
     */
    private static void Component_Frame_Demo(Frame frame) {
        //  构造一个最初不可见的Frame窗体新实例;
//        frame = new Frame("我是个标题吖!");
        frame.setVisible(true);                 //  设置窗体是否可见
//        frame.setLocation(200, 100);      //  设置窗体打开后出现的位置
//        frame.setSize(500, 300);          //  设置窗体大小
        frame.setBounds(200, 100, 500, 300);//  先设置坐标位置, 再设置宽和高
        frame.setLayout(new FlowLayout());  //  设置窗体的布局, FlowLayout(流式布局)

        //  构建一个button按钮新实例
        Button button = new Button("一个按钮啊!");// 创建后默认为边界式布局, 剧中并拉伸在窗体中

        frame.add(button);  //  将这个按钮添加到窗体中

    }

    /**
     * 创建一个文本输入框, 并添加到frame中
     */
    private static void Component_TextArea_Demo(Frame frame) {
        TextField textField= new TextField(15);
        textField.setBounds(20, 10, 20, 5);
        frame.add(textField);
    }

    /**
     * 1, 添加窗体监听器
     * 2, 继承WindowAdapter类, 并覆盖需求的原有方法windowClosing(WindowEvent e);
     * @param frame
     */
    private static void Event_Listener(Frame frame) {
        //  添加窗体监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            // 继承WindowAdapter覆盖windowClosing方法, 关闭窗口
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
//                System.out.println("coding");
                //  退出系统
                System.exit(0);
            }
        });
    }

}
