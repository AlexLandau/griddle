package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.DefaultTextDoubleClickStrategy;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class GdlConfiguration extends SourceViewerConfiguration {
	private ITextDoubleClickStrategy doubleClickStrategy;
//	private XMLTagScanner tagScanner;
	private GdlScanner scanner;
	private ColorManager colorManager;

	public GdlConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}
	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
//			GdlPartitionScanner.GDL,
//			GdlPartitionScanner.GDL_COMMENT
			};
	}
	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new DefaultTextDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected GdlScanner getGdlScanner() {
		if (scanner == null) {
			scanner = new GdlScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(GdlColorConstants.DEFAULT))));
		}
		return scanner;
	}

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		return new GdlContentFormatter();
	}

	//This defines the behavior of the text that shows up when hovering over
	//the icons on the left side of the editor.
	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new DefaultAnnotationHover();
	}

	//TODO: Cache all these?
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer,
			String contentType) {
		return new DefaultTextHover(sourceViewer);
	}

	@Override
	public String[] getIndentPrefixes(ISourceViewer sourceViewer,
			String contentType) {
		// TODO Auto-generated method stub
//		return super.getIndentPrefixes(sourceViewer, contentType);
		return new String[] { "    ", "\t" };
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(
			ISourceViewer sourceViewer, String contentType) {
		// TODO Auto-generated method stub
//		return super.getAutoEditStrategies(sourceViewer, contentType);
		return new IAutoEditStrategy[] {
				new GdlAutoIndentStrategy()
				};
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getGdlScanner());
		//TODO: Fix this?
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	//TODO: Override getIndentPrefixes?

}