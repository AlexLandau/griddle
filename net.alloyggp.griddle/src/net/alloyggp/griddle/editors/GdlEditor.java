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
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
