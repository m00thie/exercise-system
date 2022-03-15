package com.exercise.system.exercisesystem.config.jpa;

import com.exercise.system.exercisesystem.ExerciseSystemApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackageClasses = ExerciseSystemApplication.class)
@EnableTransactionManagement
public class PostgresConfig {

}
