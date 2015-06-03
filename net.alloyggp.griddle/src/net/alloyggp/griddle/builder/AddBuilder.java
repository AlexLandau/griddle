package net.alloyggp.griddle.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/*
 * Note: Much of this code was lifted from the tutorial at
 * http://codeandme.blogspot.com/2012/10/integrating-custom-builder.html
 */
public class AddBuilder extends AbstractHandler implements IHandler {

 @Override
 public Object execute(final ExecutionEvent event) {
  final IProject project = getProject(event);

  if (project != null) {
   try {
    // verify already registered builders
    if (hasBuilder(project)) {
     // already enabled
    	System.out.println("Already has builder");
     return null;
    }
    System.out.println("Adding builder");

    // add builder to project properties
    IProjectDescription description = project.getDescription();
    final ICommand buildCommand = description.newCommand();
    buildCommand.setBuilderName(GdlBuilder.BUILDER_ID);

    final List<ICommand> commands = new ArrayList<ICommand>();
    commands.addAll(Arrays.asList(description.getBuildSpec()));
    commands.add(buildCommand);

    System.out.println("Commands: " + commands);

    description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
    project.setDescription(description, null);
    System.out.println("Setting project description, build spec");

   } catch (final CoreException e) {
    // TODO could not read/write project description
    e.printStackTrace();
   }
  }

  return null;
 }

 public static IProject getProject(final ExecutionEvent event) {
  final ISelection selection = HandlerUtil.getCurrentSelection(event);
  if (selection instanceof IStructuredSelection) {
   final Object element = ((IStructuredSelection) selection).getFirstElement();

   System.out.println("Returning a project from the adapter");
   return (IProject) Platform.getAdapterManager().getAdapter(element, IProject.class);
  }

  System.out.println("Returning a null project");
  return null;
 }

 public static final boolean hasBuilder(final IProject project) {
  try {
   for (final ICommand buildSpec : project.getDescription().getBuildSpec()) {
    if (GdlBuilder.BUILDER_ID.equals(buildSpec.getBuilderName()))
     return true;
   }
  } catch (final CoreException e) {
  }

  return false;
 }
}
