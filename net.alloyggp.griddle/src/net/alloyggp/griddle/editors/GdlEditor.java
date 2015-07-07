package net.alloyggp.griddle.editors;

import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;

public class GdlEditor extends TextEditor {

    private ColorManager colorManager;

    public GdlEditor() {
        super();
        colorManager = new ColorManager();
        setSourceViewerConfiguration(new GdlConfiguration(colorManager));
        setDocumentProvider(new FileDocumentProvider());
    }

    @Override
    protected void initializeEditor() {
        super.initializeEditor();
        //If we don't do this, this gets set to just "#TextEditorContext", which is stupid.
        setEditorContextMenuId("net.alloyggp.griddle.editors.GdlEditor#TextEditorContext");
    }

    @Override
    public void dispose() {
        colorManager.dispose();
        super.dispose();
    }

}
