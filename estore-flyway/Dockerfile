ARG DOCKER_REGISTRY
ARG JAVA_BASE_IMAGE_TAG

FROM ${DOCKER_REGISTRY}/nr-dev/java:${JAVA_BASE_IMAGE_TAG}
ARG FLYWAY_VERSION

WORKDIR /flyway

ARG STATIC_ARTIFACT_SOURCE=https://nr-nexus.rambus.com/content/sites/devops-artifacts

ADD ${STATIC_ARTIFACT_SOURCE}/flyway-commandline-${FLYWAY_VERSION}.tar.gz flyway-commandline-${FLYWAY_VERSION}.tar.gz

RUN tar -xzf flyway-commandline-${FLYWAY_VERSION}.tar.gz --strip-components=1 \
  && rm flyway-commandline-${FLYWAY_VERSION}.tar.gz \
  && rm -rf jre \
  && ln -s /flyway/flyway /usr/local/bin/flyway

ADD target/jars/* /flyway/jars/
ADD target/drivers/* /flyway/drivers/

#Fix for https://github.com/flyway/flyway/issues/628
ADD target/lib/* /flyway/lib/community/
ADD target/lib/* /flyway/lib/pro/
ADD target/jars/* /flyway/lib/community/
ADD target/jars/* /flyway/lib/pro/

ADD flyway.conf /flyway/conf/flyway.conf

ENTRYPOINT ["flyway"]
CMD ["-?"]