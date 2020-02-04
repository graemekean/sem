# Use the latest MySQL image

FROM mysql

# Set the working directory

WORKDIR /tmp

# Copy all the files to the working directory of the container

COPY world.sql /tmp/


# Copy the main SQL file to docker-entrypoint-initdb.d.

# Scripts and SQL files in this folder are executed on container startup.

# This is specific to MySQL.

COPY world.sql /docker-entrypoint-initdb.d

# Set the root password

ENV MYSQL_ROOT_PASSWORD example

#docker exec -it 9d18e39aec4351e5204fc3673e4f51a65eceb183a0d42b8d1d6ccd54ca5e9f36 bash


#bash: root@9d18e39aec43:/tmp#: No such file or direc

