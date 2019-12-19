FROM kjyz1125/prom7
MAINTAINER kjyz1125@gmail.com (https://github.com/kjyz1125)

# ADD setenv.sh ${CATALINA_HOME}/bin/setenv.sh
ENV CATALINA_HOME=/usr/local/tomcat
RUN rm -Rf ${CATALINA_HOME}/webapps/ROOT
# RUN apt-get update && apt-get install -y vim
ADD build/libs/*.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080