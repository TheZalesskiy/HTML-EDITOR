package controller;

import exception.ExceptionHandler;
import htmlFileFilter.HTMLFileFilter;
import view.View;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Controller class
 * date: 14.06.2016
 *
 * @autor TheZalesskie
 */
public class Controller {
    private View view;
    private HTMLDocument document;

    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }
    //getter for model


    public HTMLDocument getDocument() {
        return document;
    }

    public static void main(String[] args) {
        //create obgect view
        View view = new View();
        //create controller with view
        Controller controller = new Controller(view);

        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();


    }

    public void exit() {
        System.exit(0);

    }

    public void resetDocument() {
        if (document != null) {
            // Delete the current document document listener edits that you can undo / redo
            document.removeUndoableEditListener(view.getUndoListener());
        }
        //Create a new document by default and assigns it to the field document
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        // Add a new document revisions listener
        document.addUndoableEditListener(view.getUndoListener());
        //update
        view.update();
    }

    public void setPlainText(String text) {
        //Throw paper
        resetDocument();
        //Create a new Reader StringReader on the basis of the transmitted text
        StringReader stringReader = new StringReader(text);
        try {
            //Call the read () method, which subtracts the data from Reader in paper document.
            new HTMLEditorKit().read(stringReader, document, 0);
        }catch (Exception e){
            ExceptionHandler.log(e);
        }

    }
    public String getPlainText(){
        //create object StringWriter
        StringWriter stringWriter = new StringWriter();
        try {
            //Call the read () method, which subtracts the data from Reader in paper document.
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        }catch (Exception e){
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }


    public void createNewDocument() {
        // Select html tab at presentation
        view.selectHtmlTab();
        // Reset the current document
        resetDocument();
        // Set the new window title
        view.setTitle("HTML редактор");
        // Reset the changes in the Undo manager
        view.resetUndo();
        // Reset variable currentFile
        currentFile = null;

    }

    public void openDocument() {

        // Toggle view on html tab
        view.selectHtmlTab();
        // Create a new object to select file JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        // Set it as a filter object HTMLFileFilter
        jFileChooser.setFileFilter(new HTMLFileFilter());
        // Show the dialog box "Save File" to select the file
        int n = jFileChooser.showOpenDialog(view);

        // When the file is selected , you must
        if (n == JFileChooser.APPROVE_OPTION) {
            // Set the new value currentFile
            currentFile = jFileChooser.getSelectedFile();
            //reset document
            resetDocument();
            // Set the file name in the header at the presentation
            view.setTitle(currentFile.getName());

            //creating FileReader, current currentFile
            try (FileReader fileReader = new FileReader(currentFile)) {
                // Subtract data from the FileReader and - paper document using a class object
                new HTMLEditorKit().read(fileReader, document, 0);
                //reset Undo
                view.resetUndo();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        // The method should also work as saveDocumentAs (), but does not request a file from the user ,
        // And use currentFile. If currentFile is null, the cause saveDocumentAs () method.

        if (currentFile == null) {
            saveDocumentAs();
        }
        else {
            // Toggle view on html tab
            view.selectHtmlTab();

            // Create FileWriter based currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                // Overwrite data from document to document and FileWriter- object in the same way as we did in getPlainText () method
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        // Toggle view on html tab
        view.selectHtmlTab();
        // Create a new object to select file JFileChooser
        JFileChooser jFileChooser = new JFileChooser();
        //Install it as a filter HTMLFileFilter object.
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Show "Save File" dialog box to select the file .
        int n = jFileChooser.showSaveDialog(view);
        // If the user confirms the file selection:
        if (n == JFileChooser.APPROVE_OPTION) {
            // Save the file in the field currentFile
            currentFile = jFileChooser.getSelectedFile();
            // Set the file name as the title of the view window
            view.setTitle(currentFile.getName());

            //created FileWriter on the base currentFile
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                /** Overwrite data from document to document and FileWriter- object in the same way as we did in getPlainText () method*/
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }


        }
    }

}
