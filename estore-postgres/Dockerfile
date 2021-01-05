ARG DOCKER_REGISTRY
FROM ${DOCKER_REGISTRY}/nr-dev/postgres:9.6.6
ADD postgresql.conf /etc/postgresql/postgresql.conf
ADD schemas.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_USER=tsp
ENV POSTGRES_DB=tsp
ENV POSTGRES_PASSWORD=tsp