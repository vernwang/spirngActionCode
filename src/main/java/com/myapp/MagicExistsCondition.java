package com.myapp;

import javax.ws.rs.core.MultivaluedMap;

import org.hamcrest.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import io.fabric8.api.Profiles;

public class MagicExistsCondition  implements org.springframework.context.annotation.Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
//		Environment environment=context.getEnvironment();
//		
//		
//		return environment.containsProperty("magic");
		
		if(context.getEnvironment()!=null) {
			MultiValueMap<String, Object> attrs= metadata.getAllAnnotationAttributes(null);
			if(attrs !=null) {
				for(Object value: attrs.get("value")) {
					if(context.getEnvironment().acceptsProfiles((String[]) value)) {
						return true;
					}
				}
				return false;
			}
		}
		
		return false;
		
	}

}
