import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import org.apache.http.util.TextUtils;
import sun.rmi.runtime.Log;
import ui.ShowCodeDialog;

import java.util.logging.Logger;

public class quickLog extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Messages.showMessageDialog("你好", "快速插件", Messages.getInformationIcon());
//        Project project = e.getData(PlatformDataKeys.PROJECT);
//        PsiFile file = e.getData(PlatformDataKeys.PSI_FILE);

        //1、获取当前选中的单词
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        if (null == editor) return;
        SelectionModel model = editor.getSelectionModel();
        final String selectText = model.getSelectedText();
        if (TextUtils.isEmpty(selectText)) {
            return;
        }
        System.out.println(" 插件插件========1111========  " + selectText);
        //2、生成代码
        // Log.i("LHD", "");
//        String resultCode = String.format("Log.i(\"LHD\", \"%s\");", selectText);
//        System.out.println(" 插件插件========2222========  " + selectText);
//        ShowCodeDialog dialog = new ShowCodeDialog(resultCode);
//        dialog.pack();
//        dialog.setSize(600, 400);
//        dialog.setLocationRelativeTo(null);
//        dialog.setVisible(true);
//        dialog.requestFocus();
//        Messages.showMessageDialog("你好" + selectText, "快速插件", Messages.getInformationIcon());
    }
}
