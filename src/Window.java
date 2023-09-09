import javax.swing.*;
import java.awt.*;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;


public class Window extends JFrame {
    JTextPane textPane = new JTextPane();
    Calculator calc = new Calculator(textPane);

    Dimension buttonSize = new Dimension(60, 35);
    Dimension buttonPanelSize = new Dimension(120, 45);

    JRadioButton onButton = new JRadioButton("float");
    JRadioButton offButton = new JRadioButton("int   ");


    public Window() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setVisible(true);
        this.buildMenu();
        this.pack();
        this.setResizable(false);
    }

    private void buildMenu(){
        this.setPreferredSize(new DimensionUIResource(300, 380));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 10));
        this.getContentPane().setBackground(Color.BLACK);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.BLACK);
        textPane.setPreferredSize(new DimensionUIResource(260, 30));
        textPane.setEditable(false);
        textPane.setFont(new Font("SansSerif", 0, 18));
        textPanel.add(textPane);
        this.add(textPanel);

        JPanel firstRow = new JPanel();
        firstRow.setBackground(Color.BLACK);
        firstRow.setPreferredSize(new DimensionUIResource(300, 46));
        firstRow.setLayout(new FlowLayout(FlowLayout.CENTER, 6, 0));
        this.add(firstRow);

        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(Color.BLACK);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        radioPanel.setPreferredSize(new DimensionUIResource(60, 60));
        firstRow.add(radioPanel);

        JPanel firstRowButtons = new JPanel();
        firstRowButtons.setBackground(Color.BLACK);
        //firstRowButtons.setPreferredSize(new DimensionUIResource(300, 30));
        firstRowButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 10));
        firstRow.add(firstRowButtons);

        onButton.setBackground(Color.BLACK);
        onButton.setForeground(Color.WHITE);
        onButton.setSelected(true);
        radioPanel.add(onButton);
        offButton.setBackground(Color.BLACK);
        offButton.setForeground(Color.WHITE);
        radioPanel.add(offButton);
        offButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                onButton.setSelected(false);
                calc.setIntMode(true);
                offButton.setSelected(true);
            } 
        });
        onButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                onButton.setSelected(true);
                offButton.setSelected(false);
                calc.setIntMode(false);
            } 
        });

        newButton("C", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.clear();
            } 
        },firstRowButtons , Color.RED, Color.WHITE);

        newButton("DEL", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.del();
            } 
        },firstRowButtons , Color.RED, Color.WHITE);
    
        newButton("/", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.div();
            } 
        },firstRowButtons , Color.ORANGE);

        newButton("\u221A", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.sqrt();
            } 
        });

        newButton("x"+"\u00B2", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.square();
            } 
        });

        newButton("1/x", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.inverse();
            } 
        });

        newButton("-", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.sub();
            } 
        }, Color.ORANGE);

        newButton("7", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(7);
            } 
        });

        newButton("8", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(8);
            } 
        });

        newButton("9", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(9);
            } 
        });

        newButton("X", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.mult();
            } 
        }, Color.ORANGE);

        newButton("4", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(4);
            } 
        });

        newButton("5", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(5);
            } 
        });

        newButton("6", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(6);
            } 
        });

        newButton("+", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.add();
            } 
        }, Color.ORANGE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panel.setPreferredSize(new DimensionUIResource(197, 80));
        
        this.add(panel);

        JPanel row1 = new JPanel();
        row1.setBackground(Color.BLACK);
        row1.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 0));
        row1.setPreferredSize(new DimensionUIResource(205, 40));
        panel.add(row1);

        JPanel row2 = new JPanel();
        row2.setBackground(Color.BLACK);
        row2.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 5));
        row2.setPreferredSize(new DimensionUIResource(205, 40));
        panel.add(row2);


        newButton("=", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.enter();
            } 
        }, Color.ORANGE, new DimensionUIResource(60, 80));
    

        newButton("1", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(1);
            } 
        }, row1);

        newButton("2", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(2);
            } 
        }, row1);

        newButton("3", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(3);
            } 
        }, row1);

        newButton("0", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.numInput(0);
            } 
        }, row2, new DimensionUIResource(128, 35));

        newButton(".", new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                calc.decimalPoint();
            } 
        }, row2);
    }

    private void newButton(String text, ActionListener listener){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.setPreferredSize(buttonPanelSize);
        internalPanel.add(button);
        button.setPreferredSize(buttonSize);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(button);
    }

    private void newButton(String text, ActionListener listener, Color color){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.setPreferredSize(buttonPanelSize);
        internalPanel.add(button);
        button.setPreferredSize(buttonSize);
        button.setBackground(color);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(button);
    }

    private void newButton(String text, ActionListener listener, DimensionUIResource dimension){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.add(button);
        button.setPreferredSize(dimension);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(button);
    }

    private void newButton(String text, ActionListener listener, Color color, DimensionUIResource dimension){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.add(button);
        button.setPreferredSize(dimension);
        button.setBackground(color);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(button);
    }

    private void newButton(String text, ActionListener listener, JPanel panel){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.setPreferredSize(buttonPanelSize);
        internalPanel.add(button);
        button.setPreferredSize(buttonSize);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button);
    }

    private void newButton(String text, ActionListener listener, JPanel panel, Color color){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.setPreferredSize(buttonPanelSize);
        internalPanel.add(button);
        button.setPreferredSize(buttonSize);
        button.setBackground(color);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button);
    }

    private void newButton(String text, ActionListener listener, JPanel panel, DimensionUIResource dimension){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.add(button);
        button.setPreferredSize(dimension);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button);
    }

    private void newButton(String text, ActionListener listener, JPanel panel, Color color, DimensionUIResource dimension){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.add(button);
        button.setPreferredSize(dimension);
        button.setBackground(color);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button);
    }

    private void newButton(String text, ActionListener listener, JPanel panel, Color color, Color textColor){
        JButton button = new JButton(text);
        JPanel internalPanel = new JPanel();
        internalPanel.setBackground(Color.BLACK);
        internalPanel.setPreferredSize(buttonPanelSize);
        internalPanel.add(button);
        button.setPreferredSize(buttonSize);
        button.setBackground(color);
        button.setForeground(textColor);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(button);
    }
}