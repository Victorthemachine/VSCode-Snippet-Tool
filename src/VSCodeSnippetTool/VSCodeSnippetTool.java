/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VSCodeSnippetTool;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Tanya
 */
public class VSCodeSnippetTool extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLb = new Label("Enter name of the snippet");
        TextField nameTf = new TextField();
        nameTf.promptTextProperty().set("Please supply a name");

        Label langLb = new Label("Enter programming language");
        TextField langTf = new TextField();
        langTf.promptTextProperty().set("Please specify language scope");

        Label prefixLb = new Label("Enter prefix (shorthand) for the snippet");
        TextField prefixTf = new TextField();
        prefixTf.promptTextProperty().set("Please supply a prefix");

        Label codeLb = new Label("Enter code of the snippet");
        TextArea codeTa = new TextArea();
        codeTa.promptTextProperty().set("Paste your code here");

        Label successLb = new Label();
        
        Button btn = new Button();
        btn.setText("Process");
        btn.setOnAction((event) -> {
            JSONObject object = new JSONObject();
            object.put(nameTf.getText(),
                    new JSONObject()
                            .put("scope", langTf.getText())
                            .put("prefix", prefixTf.getText())
                            .put("body", new JSONArray(StringManipulator.formatTheCodeBlock(codeTa.getText())))
            );
            String stringifiedJSON = object.toString(4);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(stringifiedJSON.substring(1, stringifiedJSON.length() - 1) + ","), null);
            successLb.setText("Copied the text to your clipboard! Just paste it into the .vscode/snippets.code-snippets file");
        });
        
        VBox root = new VBox();

        root.getChildren().addAll(nameLb, nameTf, langLb, langTf, prefixLb, prefixTf, codeLb, codeTa, btn, successLb);
        root.setVgrow(codeTa, Priority.ALWAYS);

        Scene scene = new Scene(root);

        primaryStage.setTitle("VSCode Snippet Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
