package gool.imports.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface ForcePlatform {
	String platform();
}
 