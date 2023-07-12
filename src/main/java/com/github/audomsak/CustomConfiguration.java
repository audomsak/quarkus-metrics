package com.github.audomsak;

import java.util.Arrays;

import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.config.MeterFilter;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.quarkus.micrometer.runtime.MeterFilterConstraint;
import jakarta.inject.Singleton;
import jakarta.enterprise.inject.Produces;

@Singleton
public class CustomConfiguration {

    /** Define common tags that apply only to a Prometheus Registry */
    @Produces
    @Singleton
    @MeterFilterConstraint(applyTo = PrometheusMeterRegistry.class)
    public MeterFilter configurePrometheusRegistries() {
        return MeterFilter.commonTags(Arrays.asList(
                Tag.of("application", "quarkus-metrics")));
    }

}
