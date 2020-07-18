package spring.boot.webApp.Spring.Boot.Web.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UserAllowed {
	public enum DatTabs{
		INQUIRY,
		CREATE_CLAIM,
		MAINTENANCE,
		APPROVAL,
		STATISTICS,
		DOCUMENTS
	}
	
	DatTabs datTabs();
}
