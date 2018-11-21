package ee.mtiidla.swimresult.di

import javax.inject.Scope

/**
 * Identifies a type that the injector only instantiates once per Application instance.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope