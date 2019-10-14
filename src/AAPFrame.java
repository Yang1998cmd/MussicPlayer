import Plugin.IPlayerPlugin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AAPFrame {
    private JLabel label;
    private JButton choose;
    private String fileName;
    private JPanel panel;
    private FileDialog fileDialog;
    public static JTextArea showTEXT;



    public AAPFrame() {
        panel = new JPanel ();
        label = new JLabel ("请选择音频：");
        choose = new JButton ("音频选择");
        showTEXT = new JTextArea ();
        fileName = "";
        JFrame jFrame = new JFrame ("插件开发");
        jFrame.setContentPane (this.panel);
        jFrame.setLocation (400, 280);
        jFrame.setSize (400, 260);
        jFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //jFrame.pack();
        jFrame.setVisible (true);
        panel.setLayout(null);

        label.setBounds (100, 20, 80, 40);
        panel.add (label);
        choose.setBounds (180, 20, 150, 40);
        panel.add (choose);
        choose.addActionListener (new ActionListener () {

            public void actionPerformed(ActionEvent e) {
                fileDialog = new FileDialog ((Frame) null, "请选择文件打开！");
                fileDialog.setBounds (300, 300, 200, 400);
                fileDialog.setMode (FileDialog.LOAD);
                fileDialog.setVisible (true);
                String file = fileDialog.getFile ();
                System.out.print(file);

                if (file != null) fileName = file;

                Class clazz = null;//java反射机制
                try {
                    //System.out.print(fileName.split (".")[1]+" "+fileName.split (".")[0]);
                    String className = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.out.print(className);
                    clazz = Class.forName (className + "." + className);
                    Constructor constructor = clazz.getConstructor (File.class);//获取有参构造
                    IPlayerPlugin instance = (IPlayerPlugin) constructor.newInstance (new File (fileName));    //通过有参构造创建对象
                    instance.service ();
                } catch (InstantiationException ex) {
                    ex.printStackTrace ();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace ();
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace ();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace ();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace ();
                }
            }
        });
        showTEXT.setBounds (10,100,360,100);
        panel.add (showTEXT);
        showTEXT.setColumns(4);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 100, 360, 100);
        scrollPane.setViewportView(showTEXT);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

    }


}
