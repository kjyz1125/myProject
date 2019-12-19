FROM 584828397695.dkr.ecr.ap-northeast-2.amazonaws.com/tomcat
MAINTAINER kjyz1125@gmail.com (https://github.com/kjyz1125)

# ADD setenv.sh ${CATALINA_HOME}/bin/setenv.sh
ENV CATALINA_HOME=/usr/local/tomcat
RUN rm -Rf ${CATALINA_HOME}/webapps/ROOT
# RUN apt-get update && apt-get install -y vim
ADD build/libs/*.war ${CATALINA_HOME}/webapps/ROOT.war
EXPOSE 8080