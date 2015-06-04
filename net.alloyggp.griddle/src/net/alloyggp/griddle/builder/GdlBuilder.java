package net.alloyggp.griddle.builder;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import net.alloyggp.griddle.GdlProblem;
import net.alloyggp.griddle.validator.Validator;
import net.alloyggp.griddle.validator.Validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

//Note: Much of this code was lifted from the Eclipse Platform Plug-in Developer Guide.
public class GdlBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "net.alloyggp.griddle.gdlValidator";

	@Override
	protected IProject[] build(int kind, Map<String, String> args,
			IProgressMonitor monitor) throws CoreException {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
	         fullBuild(monitor);
	      } else {
	         IResourceDelta delta = getDelta(getProject());
	         if (delta == null) {
	            fullBuild(monitor);
	         } else {
	            incrementalBuild(delta, monitor);
	         }
	      }
	      return null;
	}

	private void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) {
		try {
			delta.accept(new GdlMarkingDeltaVisitor());
		} catch (CoreException e) {
			//TODO: Remove this?
			e.printStackTrace();
			//Do nothing
		}
	}

	private void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new GdlMarkingVisitor());
		} catch (CoreException e) {
			//TODO: Remove this?
			e.printStackTrace();
			//Do nothing
		}
	}

	private static class GdlMarkingVisitor implements IResourceVisitor {
		@Override
		public boolean visit(IResource resource) {
			//build the specified resource.
			try {
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
					resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

					parseAndAddMarkers(resource);
				}
			} catch (CoreException e) {
				//TODO: Remove this?
				e.printStackTrace();
				//Do nothing
			}
			//return true to continue visiting children.
			return true;
		}
	}

	private static class GdlMarkingDeltaVisitor implements IResourceDeltaVisitor {

		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			//build the specified resource.
			try {
				IResource resource = delta.getResource();
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
					resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

					if (delta.getKind() != IResourceDelta.REMOVED) {
						parseAndAddMarkers(resource);
					}
				}
			} catch (CoreException e) {
				//TODO: Remove this?
				e.printStackTrace();
				//Do nothing
			}
			//return true to continue visiting children.
			return true;
		}

	}

	public static IResourceVisitor getMarkerClearingVisitor() {
		return new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource.getType() == IResource.FILE && resource.exists()
						&& ("kif".equalsIgnoreCase(resource.getFileExtension()) ||
								"gdl".equalsIgnoreCase(resource.getFileExtension()))) {
						resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
				}

				//return true to continue visiting children.
				return true;
			}
		};
	}

	public static void parseAndAddMarkers(IResource resource) throws CoreException {
		String fileContents;
		try {
			fileContents = getFileResourceAsString(resource);
		} catch (IOException e) {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.MESSAGE, "Unknown IO error when parsing resource");
			return;
		}

		Validator validator = Validators.getStandardValidator();
		Set<GdlProblem> problems = validator.findProblems(fileContents);
		for (GdlProblem problem : problems) {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			if (problem.isError()) {
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			} else {
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
			}
			marker.setAttribute(IMarker.MESSAGE, problem.getMessage());
			marker.setAttribute(IMarker.CHAR_START, problem.getPosition().getStart());
			marker.setAttribute(IMarker.CHAR_END, problem.getPosition().getEnd());
		}
	}

	private static String getFileResourceAsString(IResource resource)
			throws CoreException, IOException {
		InputStream fileContentStream = new BufferedInputStream(((IFile) resource).getContents());
		StringBuilder sb = new StringBuilder();
		while (true) {
			int c = fileContentStream.read();
			if (c == -1) {
				break;
			}
			sb.append((char) c);
		}
		fileContentStream.close();
		return sb.toString();
	}

	//TODO: Figure this out
//	@Override
//	public ISchedulingRule getRule(int kind, Map<String, String> args) {
//		// TODO Auto-generated method stub
//		return super.getRule(kind, args);
//	}

}
