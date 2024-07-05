import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置大小
        frame.setSize(500, 500);
        frame.setLocation(50, 50);
        // 设置布局,默认会使用BorderLayout
        frame.setLayout(null);

        // 创建按钮
        Button button = new Button("Click Me");
        // 设置位置和大小
        button.setBounds(20,50,100, 50);

        Image image = Toolkit.getDefaultToolkit().getImage("");

        // 窗口增加组件
        frame.add(button);
        // 显示窗口
        frame.setVisible(true);
    }
}
