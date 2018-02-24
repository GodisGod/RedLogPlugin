package core;

import com.intellij.psi.PsiFile;
import utils.StringUtils;


public class CodeFactory {

    public static String createLogCode(PsiFile psiFile) {
        String[] getChanges = StringUtils.getAllVariables(psiFile);
        return "";
    }


}
