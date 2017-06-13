package UI;

import java.awt.*;

import java.awt.geom.*;

import javax.swing.*;

/**
 *
 * @author LE BAO
 */
public class ArrayComponent extends JComponent {

    private int comparisons = 0;

    private Integer[] values;

    private Integer marked1;

    private Integer marked2;

    private boolean isLessThan20;

    public synchronized void paintComponent(Graphics g) {

        if (values == null) {

            return;
        }

        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("TimesRoman", Font.PLAIN, 16));

        int width = getWidth() / values.length;

        int height = getHeight();

        for (int i = 0; i < values.length; i++) {

            Integer v = values[i];

            Rectangle2D rectangle = null;

            if (this.isLessThan20) {

                rectangle = new Rectangle2D.Double(i * 30, 20, 30, values[i] * 30);

            } else {

                rectangle = new Rectangle2D.Double(i * 30, 20, 30, values[i] * 2);

            }

            if (v == marked1 || v == marked2) {

                g2.setColor(Color.red);

                g2.fill(rectangle);

                g2.setColor(Color.black);

            } else {

                g2.draw(rectangle);

            }

            g2.drawString("" + values[i], i * 30, height - 455);

            g2.drawString("Comparisons:" + comparisons, 5, height - 5);

        }

    }

    public synchronized void setValues(Integer[] values, Integer marked1, Integer marked2, boolean isLessThan20) {

        this.values = (Integer[]) values.clone();

        this.marked1 = marked1;

        this.marked2 = marked2;

        this.isLessThan20 = isLessThan20;

        comparisons++;

        repaint();

    }

    public void reset() {

        comparisons = 0;

    }

}
