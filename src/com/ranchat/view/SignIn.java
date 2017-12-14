package com.ranchat.view;

import com.ranchat.dao.chat.Delete;
import com.ranchat.dto.User;
import com.ranchat.singletone.Singletone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignIn extends JFrame implements WindowListener, ActionListener{
    JLabel label;

    JTextField id;
    JPasswordField pwd;

    JButton signIn;
    JButton signUp;

    public SignIn(){
        super("Sign In");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.yellow);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>Sign In</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);


        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(100, 170, 50, 20);
        contentPane.add(idLabel);

        id = new JTextField();
        id.setBounds(100, 210, 150, 20);
        contentPane.add(id);

        JLabel pwdLabel = new JLabel("PASSWORD");
        pwdLabel.setBounds(100, 248, 150, 20);
        contentPane.add(pwdLabel);

        pwd = new JPasswordField();
        pwd.setBounds(100, 288, 150, 20);
        contentPane.add(pwd);



        JPanel panel = new JPanel();
        panel.setSize(150, 100);
        panel.setLayout(new FlowLayout());
        panel.setLocation(100, 450);

        signIn = new JButton("SIGN IN");
        signIn.setSize(150, 50);
        signIn.addActionListener(this);
        panel.add(signIn);

        signUp = new JButton("SIGN UP");
        signUp.setSize(75, 50);
        signUp.addActionListener(this);

        JButton h = new JButton("SIGN UP");
        h.setSize(75, 50);
        h.addActionListener(this);

        panel.add(h);

        contentPane.add(panel);

        setBounds(100, 100, 375, 667);
        setResizable(false);
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        Singletone.getInstance().getUsers().forEach(System.out::println);

        if(obj == signIn){
            String id = this.id.getText();
            char[] password = this.pwd.getPassword();

            if(User.isUser(id, password)){
                Singletone.getInstance().setCurrentUser(User.getUserById(id));
                new ChatList();
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Wrong ID or PASSWORD");
            }

        }else if(obj == signUp){
            new SignUp();
            this.dispose();
        }else{

        }
    }



    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
