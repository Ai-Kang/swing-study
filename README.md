# Frame类
```java
// 创建简单的一个窗口
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置窗口大小
        frame.setSize(new Dimension(800, 600));
        // 设置标题
        frame.setTitle("我是标题");
        // 设置窗口背景颜色
        frame.setBackground(new Color(255, 255, 255));
        // 是否永久展示在最前面
        frame.setAlwaysOnTop(false);
        // 设置窗口大小是否固定
        frame.setResizable(false);
        // 窗口默认位置(窗口最左上角)
//        frame.setLocation(100, 100);
        // 获取屏幕信息
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        // 获取屏幕大小
        Dimension screenSize = defaultToolkit.getScreenSize();
        // 计算剧中
        int x = (int) (screenSize.getWidth() / 2) - frame.getWidth()/2;
        int y = (int) (screenSize.getHeight() / 2) - frame.getHeight()/2;
        frame.setLocation(x, y);
        /**
         * NORMAL 默认
         * ICONIFIED 最小化
         * MAXIMIZED_HORIZ 水平最大化
         * MAXIMIZED_VERT 垂直最大化
         * MAXIMIZED_BOTH 最大化
         */
        frame.setExtendedState(Frame.NORMAL);
        // 直接设置大小和位置
//        frame.setBounds(x, y, frame.getWidth(), frame.getHeight());
        // 设置鼠标图像(不常用)
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // 显示窗口
        frame.setVisible(true);
    }
}
```
# 监听器
```java
public class Test {
    public void test(){
        new WindowListener() {
            // 首次可见打开
            @Override
            public void windowOpened(WindowEvent e) {

            }

            // 点击关闭按钮
            @Override
            public void windowClosing(WindowEvent e) {

            }

            // 窗口成功关闭
            @Override
            public void windowClosed(WindowEvent e) {

            }

            // 窗口最小化
            @Override
            public void windowIconified(WindowEvent e) {

            }

            // 窗口从最小化变为正常大小
            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            // 窗口变成活跃状态
            @Override
            public void windowActivated(WindowEvent e) {

            }

            // 窗口变成不活跃状态
            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        }
    }
}
```
## 窗口监听+适配器完成窗口关闭按钮点击关闭
```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置窗口大小
        frame.setSize(new Dimension(800, 600));
        // 设置标题
        frame.setTitle("我是标题");
        // 获取屏幕信息 获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // 计算居中
        frame.setLocation((int) (screenSize.getWidth() / 2) - frame.getWidth() / 2, (int) (screenSize.getHeight() / 2) - frame.getHeight() / 2);
        // 添加窗口关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭窗口
                frame.dispose();
                System.out.println("窗口关闭了");
            }
        });
        // 显示窗口
        frame.setVisible(true);
    }
}
```
## 鼠标,窗口,键盘事件监听
```java
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置窗口大小
        frame.setSize(new Dimension(800, 600));
        // 设置标题
        frame.setTitle("我是标题");
        // 获取屏幕信息 获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // 计算剧中
        frame.setLocation((int) (screenSize.getWidth() / 2) - frame.getWidth() / 2, (int) (screenSize.getHeight() / 2) - frame.getHeight() / 2);
        // 添加窗口关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭窗口
                frame.dispose();
                System.out.println("窗口关闭了");
            }
        });
        // 监听回车按钮关闭
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    frame.dispose();
                }
            }
        });
        // 添加鼠标点击监听
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("鼠标点击了" + e.getX() + "," + e.getY());
            }
        });
        // 鼠标滚动
        frame.addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("滚动了"+e.getButton());
            }
        });
        // 显示窗口
        frame.setVisible(true);
    }
}
```
# 常用组件
## 按钮
## 标签
```java
  public static void main(String[] args) {
    Frame frame = new Frame();
    // 设置大小
    frame.setSize(500, 500);
    frame.setLocation(50, 50);
    // 设置布局,默认会使用BorderLayout
    frame.setLayout(null);
    // 创建一个标签
    Label label = new Label();
    label.setText("my is label");
    // 设置位置和大小
    label.setBounds(20, 50, 100, 30);
    // 设置字体和大小
    label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
    // 设置背景颜色
    label.setBackground(new Color(160, 56, 56));
    // 设置字体颜色
    label.setForeground(new Color(255, 255, 255));

    // 窗口增加组件
    frame.add(label);
    // 显示窗口
    frame.setVisible(true);
}
```
## 文本框
