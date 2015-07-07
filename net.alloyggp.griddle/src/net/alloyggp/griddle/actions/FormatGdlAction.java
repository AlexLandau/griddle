package net.alloyggp.griddle.actions;

import net.alloyggp.griddle.editors.GdlEditor;
import net.alloyggp.griddle.indentation.GameIndenter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class FormatGdlAction extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IEditorPart editor = HandlerUtil.getActiveEditorChecked(event);
        GdlEditor gdlEditor = (GdlEditor) editor;
        IDocumentProvider documentProvider = gdlEditor.getDocumentProvider();
        IDocument document = documentProvider.getDocument(gdlEditor.getEditorInput());
        String docAsText = document.get();
        try {
            String formatted = GameIndenter.reindentGameDescription(docAsText);
            document.set(formatted);
        } catch (Exception e) {
            throw new ExecutionException("Failed to reformat game description", e);
        }
        return null;
    }

}
