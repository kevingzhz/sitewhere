![SiteWhere] (http://www.sitewhere.org/sites/default/files/sitewhere.png)

SiteWhere Open Source M2M Integration Platform
----------------------------------------------

#### SiteWhere is an open source platform for storing, processing, and analyzing M2M device data. ####

### Installing a Packaged Version

Most of the functionality provided by SiteWhere is contained in a web archive (WAR) which is installed on a customized version of [Tomcat] (http://tomcat.apache.org/). To download the latest version of SiteWhere server (including the latest WAR) check out the [downloads] (http://www.sitewhere.org/downloads) page on [sitewhere.org] (http://www.sitewhere.org/).

### Building from Source
If you want to customize SiteWhere or otherwise have a need to build it from source code, use the following steps.

#### Required Tools #####
* [Apache Maven] (http://maven.apache.org/)
* A [GIT] (http://git-scm.com/) client

#### Clone and Build #####
Clone this repository locally using:

    git clone https://github.com/reveal-technologies/sitewhere.git
    
Navigate to the newly created directory and execute:

    mvn clean install

After the build completes, a file named **sitewhere.war** should have been created in the **deploy** folder. This archive can be copied to the sitewhere server **webapps** directory to execute the updated code.

Sitewhere Intall at Ubuntu Server 14.04 64bit
----------------------------------------------

    sudo su
    apt-get update -y

###Install MongoDB

    apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
    echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | sudo -tee /etc/apt/sources.list.d/mongodb.list
    apt-get update
    apt-get install -y mongodb-org
    echo "mongodb-org hold" | sudo dpkg --set-selections
    echo "mongodb-org-server hold" | sudo dpkg --set-selections
    echo "mongodb-org-shell hold" | sudo dpkg --set-selections
    echo "mongodb-org-mongos hold" | sudo dpkg --set-selections
    echo "mongodb-org-tools hold" | sudo dpkg --set-selections
    service mongod start

###Install HIVEMQ

    wget --content-disposition http://www.hivemq.com/downloads/releases/latest
    unzip hivemq-2.1.0.zip
    cd hivemq-2.1.0/bin
    ./run.sh &

###Install Solr

> Option If you need.

    cd ~
    wget http://archive.apache.org/dist/lucene/solr/4.7.2/solr-4.7.2.tgz
    tar -xvf solr-4.7.2.tgz
    cp -R solr-4.7.2/example /opt/solr
    export PWD=/opt/solr/webapps
    apt-get install rabbitmq-server -y
    cd /opt/sitewhere/bin
    ./startup.sh

###Install Sitewhere Release Version

> It has two way for setup Sitewhere system

> You can use Latest version from github

    apt-get install maven git unzip -y
    apt-get install openjdk-7-jdk tomcat7 -y
    service tomcat7 stop
    git clone https://github.com/reveal-technologies/sitewhere.git
    cd sitewhere
    mvn clean install
    cp deploy/sitewhere $(YOUR_TOMCAT_PATH)/webapps/.
    service tomcat7 start

> You can use Sitewhere website download Release package

    wget https://s3.amazonaws.com/reveal-technologies/sitewhere-server-0.9.7.tar.gz
    tar -zxvf sitewhere-server-0.9.7.tar.gz
    mv sitewhere-server-0.9.7 /opt/sitewhere
    cd /opt/sitewhere/bin
    sh startup.sh

* * * *

Copyright (c) 2014, [Reveal Technologies](http://www.reveal-tech.com), LLC. All rights reserved.
