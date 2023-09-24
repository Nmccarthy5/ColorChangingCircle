import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorChangingCircle extends JFrame {

    private CirclePanel circlePanel;

    public ColorChangingCircle() {
        setTitle("Color Changing Circle");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        circlePanel = new CirclePanel();
        add(circlePanel, BorderLayout.CENTER);

        circlePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                circlePanel.setColor(Color.BLACK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                circlePanel.setColor(Color.WHITE);
            }
        });

        setVisible(true);
    }

    private class CirclePanel extends JPanel {
        private Color circleColor = Color.WHITE;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(circleColor);
            g.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);
        }

        public void setColor(Color color) {
            this.circleColor = color;
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorChangingCircle());
    }
}