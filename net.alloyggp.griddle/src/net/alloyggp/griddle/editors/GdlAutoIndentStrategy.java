package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

public class GdlAutoIndentStrategy implements IAutoEditStrategy {
    @Override
    public void customizeDocumentCommand(IDocument document,
            DocumentCommand command) {
        if (command.text.equals("\n") || command.text.equals("\r\n")) {
            command.text += getAutoIndent(document, command.offset);
        } else if (command.text.equals("\t")) {
            command.text = "    ";
        }
    }

    private String getAutoIndent(IDocument document, int offset) {
        try {
            int indentationLevel = 0;
            String textBeforeNewline;
            textBeforeNewline = document.get(0, offset);
            boolean inComment = false;
            for (int i = 0; i < textBeforeNewline.length(); i++) {
                char curChar = textBeforeNewline.charAt(i);
                if (inComment) {
                    if (curChar == '\n' || curChar == '\r') {
                        inComment = false;
                    }
                } else {
                    if (curChar == ';') {
                        inComment = true;
                    } else if (curChar == '(') {
                        indentationLevel++;
                    } else if (curChar == ')') {
                        indentationLevel--;
                    }
                }
            }
            StringBuilder indentBuilder = new StringBuilder();
            for (int i = 0; i < indentationLevel; i++) {
                indentBuilder.append("    ");
            }
            return indentBuilder.toString();
        } catch (BadLocationException e) {
            //Do nothing
            return "";
        }
    }
}
