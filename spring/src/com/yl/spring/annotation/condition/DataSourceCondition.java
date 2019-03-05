package com.yl.spring.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataSourceCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata arg1) {
		Environment env = context.getEnvironment();
		return env.containsProperty("database.url") &&
				env.containsProperty("database.driver") &&
				env.containsProperty("database.username") &&
				env.containsProperty("database.password");
	}

}
