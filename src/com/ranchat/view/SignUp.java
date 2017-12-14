package com.ranchat.view;

import com.ranchat.dao.user.Insert;
import com.ranchat.dto.User;
import com.ranchat.file.FileClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SignUp extends JFrame implements WindowListener, ActionListener{
    JTextField id;
    JTextField name;
    JPasswordField password;
    JPasswordField pwdConfirm;

    JButton signIn;
    JButton signUp;
    JButton main;

    JLabel label;

    public SignUp(){
        super("Sign Up");

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.orange);
        contentPane.setLayout(null);

        JLabel title = new JLabel("<html><span style='color:white;'>SIGN UP</span></html>");
        title.setBounds(150, 68, 200, 20);
        contentPane.add(title);


        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(100, 130, 50, 20);
        contentPane.add(idLabel);

        id = new JTextField();
        id.setBounds(100, 150, 150, 20);
        contentPane.add(id);


        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(100, 180, 100, 20);
        contentPane.add(nameLabel);

        name = new JTextField();
        name.setBounds(100, 200, 150, 20);
        contentPane.add(name);

        JLabel pwdLabel = new JLabel("PASSWORD");
        pwdLabel.setBounds(100, 230, 50, 20);
        contentPane.add(pwdLabel);

        password = new JPasswordField();
        password.setBounds(100, 250, 150, 20);
        contentPane.add(password);

        JLabel pwdConfirmLabel = new JLabel("PASSWORD");
        pwdConfirmLabel.setBounds(100, 280, 100, 20);
        contentPane.add(pwdConfirmLabel);

        pwdConfirm = new JPasswordField();
        pwdConfirm.setBounds(100, 300, 150, 20);
        contentPane.add(pwdConfirm);




        JPanel panel = new JPanel();
        panel.setSize(150, 100);
        panel.setLayout(new GridLayout(2,1));
        panel.setLocation(100, 450);

        signUp = new JButton("SIGN UP");
        signUp.addActionListener(this);
        panel.add(signUp);


        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 2));

        signIn = new JButton("SIGN IN");
        signIn.addActionListener(this);
        btnPanel.add(signIn);


        main = new JButton("MAIN");
        main.addActionListener(this);
        btnPanel.add(main);

        panel.add(btnPanel);

        contentPane.add(panel);



        setBounds(100, 100, 375, 667);
        setResizable(false);
        setVisible(true);
        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == signIn){
            new SignIn();
            this.dispose();
        }else if(obj == signUp){
            if(User.isCorrectPwd(password.getPassword(), pwdConfirm.getPassword())){

                Insert userInsert = new Insert();

                if(userInsert.insert(id.getText(), password.getPassword(), name.getText())){
                    FileClass fileClass = FileClass.getInstance();
                    fileClass.writeUserToFile();

                    new SignIn();
                    this.dispose();

                }else{
                    JOptionPane.showMessageDialog(null, "회원 가입중 문제가 발생했습니다.\n다시 시도해주세요.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
            }
        }else{
            new Main();
            this.dispose();
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
