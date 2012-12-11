/**
 * The class that launches the other ones, thereby controlling the workflow.
 * TODO: further parameterize concreteJavaToConcretePlatform() to have an input platform. 
 */

package gool;

import gool.ast.constructs.ClassDef;
import gool.executor.ExecutorHelper;
import gool.generator.GeneratorHelper;
import gool.generator.common.Platform;
import gool.generator.cpp.CppPlatform;
import gool.generator.csharp.CSharpPlatform;
import gool.generator.java.JavaPlatform;
import gool.parser.java.JavaParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class GOOLCompiler {
	/**
	 * Logger. XXXXXXXXX
	 */
	private static final Logger LOG = Logger.getLogger(GOOLCompiler.class);

	
	/**
	 * The main
	 * - gets the folder to open from Settings
	 * - opens the files
	 * - creates an instance of this class
	 * - triggers it upon the files, with argument the target platform.
	 */
	public static void main(String[] args) {
		try {
			File folder = new File(Settings.get("java_in_dir"));
			Collection<File> files = Arrays.asList(folder.listFiles());
			System.out.println(files);
			GOOLCompiler gc = new GOOLCompiler();
			Map<Platform, List<File>> f = gc.concreteJavaToConcretePlatform(JavaPlatform.getInstance(), files);
			System.out.println(f);
			gc.concreteJavaToConcretePlatform(CSharpPlatform.getInstance(),
					files);
			gc.concreteJavaToConcretePlatform(CppPlatform.getInstance(), files);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Taking concrete Java into concrete Target is done in two steps:
	 * - we parse the concrete Java into abstract GOOL;
	 * - we flatten the abstract GOOL into concrete Target.
	 * @param destPlatform
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public Map<Platform, List<File>> concreteJavaToConcretePlatform(
			Platform destPlatform, String input) throws Exception {
		Collection<ClassDef> classDefs = concreteJavaToAbstractGool(
				destPlatform, input);
		return abstractGool2Target(classDefs);
	}

	public Map<Platform, List<File>> concreteJavaToConcretePlatform(
			Platform destPlatform, Collection<? extends File> inputFiles)
			throws Exception {
		Collection<ClassDef> classDefs = concreteJavaToAbstractGool(
				destPlatform, inputFiles);
		return abstractGool2Target(classDefs);
	}

		
	/**
	 * Parsing the concrete Java into abstract GOOL is done by JavaParser.
	 * @param destPlatform
	 * @param input
	 * @return
	 * @throws Exception
	 */
	private Collection<ClassDef> concreteJavaToAbstractGool(
			Platform destPlatform, String input) throws Exception {
		return JavaParser.parseGool(destPlatform, input);
	}

	private Collection<ClassDef> concreteJavaToAbstractGool(
			Platform destPlatform, Collection<? extends File> inputFiles)
			throws Exception {
		return JavaParser.parseGool(destPlatform,
				ExecutorHelper.getJavaFileObjects(inputFiles));
	}

	
	/**
	 * Flattening the abstract GOOL into concrete Target is done by GeneratorHelper.
	 * XXXXXXXXXX How does it know which platform?
	 * @param classDefs
	 * @return
	 * @throws FileNotFoundException
	 */
	private Map<Platform, List<File>> abstractGool2Target(
			Collection<ClassDef> classDefs) throws FileNotFoundException {
		return GeneratorHelper.printClassDefs(classDefs);
	}

	/**
	 * XXXXXX
	 * @author root
	 */
	class result {
		Map<Platform, List<File>> files;
		File mainfile;
	}

}
