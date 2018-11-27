package BiXiangDong.GUI_Learning;

import java.awt.*;
import java.awt.event.*;

/**
 *
 */
public class GUI_Learning_1_MouseAndKeyboard_Demo {
    private Frame frame;
    private TextField textField;
    private Button button;

    GUI_Learning_1_MouseAndKeyboard_Demo(){
        init();
    }

    private void init() {
        //  创建窗体
        frame = new Frame("我是个窗口标题");
        //  设置窗体
        frame_set(frame);
        //  添加窗体监听器       adapter:适配器
        frame_Listener_set(frame);


        //  创建单行输入框
        textField = new TextField(35); //   可以写24列
        //  设置输入框
        textField_set(textField);
        //  添加文本框监听器
        textField_Listener_set(textField);


        //  创建按钮
        button = new Button("我是个按钮啊!");
        //  设置按钮
        button_set(button);
        //  添加按钮监听器
        button_Listener_set(button, textField);


        //  将文本框, 按钮 添加到frame中
        frame.add(textField);
        frame.add(button);
    }

    //  按钮设置
    private void button_set(Button button) {
        button.setBounds(410, 50, 40, 30);
    }

    //  button的监听器设置
    private void button_Listener_set(Button button, TextField textField) {
        //  给button添加鼠标监听器, 传入鼠标适配器
        button.addMouseListener(new MouseAdapter() {
            //  创建个计数器
            private int entered_count = 1;
            private int clickedOne_count = 1;
            private int clickedDouble_count = 1;
            @Override
            //  添加鼠标进入button区域的事件
            public void mouseEntered(MouseEvent e) {
//                super.mouseEntered(e);
                //  每次鼠标经过按钮, 在文本框中显示字符串
                textField.setText("mouseListener"+"鼠标移动到此处"+entered_count++);
            }

            @Override
            //  添加鼠标点击button区域的事件
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                if (e.getClickCount() == 1) {
                    //  如果鼠标点击1次
                    textField.setText("mouseListener" + "鼠标单击" + clickedOne_count++);
                    System.out.println("clickedOne_count: "+clickedOne_count);
                }
                if (e.getClickCount() == 2) {
                    //  如果鼠标点击2次
                    textField.setText("mouseListener" + "鼠标双击" + clickedDouble_count++);
                    System.out.println("clickedTwo_count: "+clickedDouble_count);
                }

            }
        });
    }

    //  textField设置
    private void textField_set(TextField textField) {
        textField.setBounds(100, 50, 300, 30);
    }

    //  textField的监听器设置
    private void textField_Listener_set(TextField textField) {
        //  给textField添加键盘监听器, 传入键盘适配器
        textField.addKeyListener(new KeyAdapter() {
            @Override
            //  添加按下键事件, 传入键盘事件
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
                //  打印 键盘事件.获取按键文本(键盘事件.获取按键值)
//                System.out.println("key run: "+KeyEvent.getKeyText(e.getKeyCode()));
                //  获取按键值
                int code = e.getKeyCode();
                //  只允许输入数字   VK_0到VK_9是常量, 其值等于0-9键的KeyCode
                if (! (code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
//                    System.out.println("必须输入数字!");
                    //  如果不是0-9键, 则不执行键盘事件e
                    e.consume();    //  e.consume  清空按键设置, 什么都不执行
                }
                //  如果按键是 enter+control 则, 打印....
                if ((e.getKeyCode() == KeyEvent.VK_ENTER) && e.isControlDown()) {
                    System.out.println("enter+control");
                }
            }
        });
    }

    //  frame设置
    private void frame_set(Frame frame) {
        //  设置打开后的坐标, 和窗体大小
        frame.setBounds(300, 200, 600, 500);
        //  设置布局管理器
        frame.setLayout(new FlowLayout());
        //  设置窗体是否可见
        frame.setVisible(true);
    }

    //  frame的监听器设置
    private static void frame_Listener_set(Frame frame) {
        //  添加窗体监听器, 传入窗口适配器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            //  添加关闭事件
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new GUI_Learning_1_MouseAndKeyboard_Demo();
    }
}
