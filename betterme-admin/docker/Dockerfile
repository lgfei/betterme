# betterme-admin dockerfile
FROM centos:lastest

MAINTAINER longuofei@163.com

# install jdk
RUN yum install java-1.8.0-openjdk* -y

# install nginx
ADD nginx/nginx.repo /etc/yum.repos.d/nginx.repo
RUN yum install nginx -y