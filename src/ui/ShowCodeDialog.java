package ui;

import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiMethod;
import utils.UiUtils;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;

public class ShowCodeDialog extends JDialog {

    private JButton cancelButton;
    private JButton confirmButton;
    private JTextArea textArea1;
    private JPanel contentPane;
    private JRadioButton VERBOSERadioButton;
    private JRadioButton DEBUGRadioButton;
    private JRadioButton INFORadioButton;
    private JRadioButton WARNRadioButton;
    private JRadioButton ERRORRadioButton;
    private ButtonGroup buttonGroup;

    public ShowCodeDialog(String code) {
        UiUtils.centerDialog(this, 300, 100);
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(confirmButton);

        textArea1.setText(code);

        confirmButton.addActionListener(e -> onOK(code));

        cancelButton.addActionListener(e -> onCancel());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        buttonGroup = new ButtonGroup();
        buttonGroup.add(VERBOSERadioButton);
        buttonGroup.add(DEBUGRadioButton);
        buttonGroup.add(INFORadioButton);
        buttonGroup.add(ERRORRadioButton);
        buttonGroup.add(WARNRadioButton);

    }

    //todo version 1.0 只选中了一个变量
    private void onOK(String code) {
        StringBuilder sb = new StringBuilder();
        //  Log.i("LHD", "  val = " + val);
        sb.append("Log.");
        //生成代码
        if (VERBOSERadioButton.isSelected()) {
            sb.append("v");
        } else if (DEBUGRadioButton.isSelected()) {
            sb.append("d");
        } else if (INFORadioButton.isSelected()) {
            sb.append("i");
        } else if (ERRORRadioButton.isSelected()) {
            sb.append("e");
        } else if (WARNRadioButton.isSelected()) {
            sb.append("w");
        } else {
            dispose();
        }
        //todo version 1.0 写死的tag
        sb.append("(\"LHD\", ");
        String str = "\"" + code + " = \" + " + code;
        sb.append(str);
        System.out.println(sb.toString());
        textArea1.setText(sb.toString());
    }

    private void onCancel() {
        dispose();
    }

}
