import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;


class MyFrame extends Frame {
    String msg = "Класс StringTokenizer из пакета java.utii небольшой, в нем три конструктора и шесть методов.";
    FontMetrics fontMetrics;
    int fontSize, space;
    int fontHeight;
    Font font;
    Dimension dimension;


    public MyFrame() {
        font = getFont();

        addWindowListener(new MyWindowAdapter(this));
    }


    public void paint (Graphics g) {
        fontMetrics = g.getFontMetrics();
        space = fontMetrics.stringWidth(" ");
        fontHeight = fontMetrics.getAscent() + fontMetrics.getDescent();
        dimension = getSize();
        StringTokenizer strToken = new StringTokenizer(msg);
        String word;
        int nextX, x = 10, y = 50;
        while (strToken.hasMoreTokens()) {
            word = strToken.nextToken();
            int wordLength = fontMetrics.stringWidth(word);
            nextX = wordLength + space + x;
            if(nextX > dimension.width) {
                x = 10;
                y += fontHeight;
                nextX = wordLength + space + x;
            }
            g.drawString(word, x, y);
            x = nextX;
        }
//        g.drawString(msg, x, y);
    }
}

class MyWindowAdapter extends WindowAdapter {
    MyFrame frame;

    MyWindowAdapter (MyFrame frame) {
        this.frame = frame;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        System.exit(0);
    }
}
public class Something  {
    public static void main(String args[]) {
        MyFrame frame = new MyFrame();
        frame.setTitle("Multiline");
        frame.setSize(250, 250);
        frame.setFont(new Font("Serif", Font.PLAIN, 14));
        frame.setVisible(true);
    }
}
