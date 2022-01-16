/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSCodeSnippetTool;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Tanya
 */
public class StringManipulator {

    /**
     * Note: I haven't tested this for anything besides Node.js.<br/>
     * If you do test it, feel free to let me know.<br/>
     * Discord: Nya~san#6539<br/>
     * email: nya.san.developer@gmail.com<br/>
     *
     * @param code
     * @return Formatted array of code to supply to VSCode
     */
    public static ArrayList<String> formatTheCodeBlock(String code) {
        ArrayList list = new ArrayList();
        String[] codeLines = code.split("\n");
        list.addAll(Arrays.asList(codeLines));
        return list;
    }
}
