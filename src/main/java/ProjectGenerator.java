import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;

public class ProjectGenerator {

		public ProjectGenerator(String ProjectName) throws CoreException {
			
			
			ProjectName="RestAssuredTestng";
			 IProgressMonitor progressMonitor = new NullProgressMonitor();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(ProjectName);
			if (!project.exists()) {
			    project.create(progressMonitor);
			    project.open(progressMonitor);
			}
			
			// Configure the project to be a Java project and a maven project
			
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] {JavaCore.NATURE_ID, "org.eclipse.m2e.core.maven2Nature" });
			

			project.setDescription(description, progressMonitor);
			
			
			
			
		}
	
		public static void main(String[] args) throws CoreException {
			
			ProjectGenerator p=new ProjectGenerator("test");
			
		}
	
	
}
