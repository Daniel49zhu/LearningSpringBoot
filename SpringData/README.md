Spring Data项目是Spring用来解决数据访问问题的一揽子解决方案，Spring Data是一个伞形项目，
包含了大量关系型数据库及非关系型数据库的数据访问解决方案。Spring Data使我们可以快速且简单地
使用普通的数据访问技术及新的数据访问技术。

Spring Data包含Spring Data JPA,Spring Data MongoDB,Spring Data Neo4J,Spring Data Redis,
Spring Data Solr,Spring Data Hadoop,Spring Data GemFire,Spring Data REST,Spring Data JDBC Extensions,
Spring Data CouchBase,Spring Data Elasticsearch,Spring Data Cassandra,Spring Data DynamoDB。

Spring Data为我们使用统一的api来对上述的数据存储技术进行数据访问操作提供了支持。这是Spring通过提供
Spring Data Commons让我们使用关系型或非关系型数据访问技术时都是用基于Spring的统一标准，该标准包含
CRUD(创建、获取、更新、删除)、查询、排序和分页的相关的操作。

此处介绍下Spring Data Commons的一个重要概念:Spring Data Repository抽象。使用Spring Data Repository可以
极大地减少数据访问层的代码。

本章将学习Spring Data JPA，Spring Data MongoDB，Spring Data REST，Spring Data REDIS。

- 引入Docker

    Docker是一个轻量级容器技术，类似于虚拟机技术(xen,kvm,vmware,vitual)。Docker是直接运行在当前操作系统(linux)之上，
    而不是运行在虚拟机中，但是也实现了虚拟机技术的资源隔离，性能远远高于虚拟机技术。
    
    Docker支持将软件编译成一个镜像(image)，在这个径向力做好对软件的各种配置，然后发布这个镜像，使用者可以
    运行这个镜像，运行中的镜像称之为容器(Container)，容器的启动是很快的，一般以秒为单位。
    
    - 常用命令
    
    检索redis：`docker search redis`
    
    镜像下载：`docker pull redis`
    
    查看本地镜像列表：`docker iamges`
    
    镜像删除：`docker rmi image-id`
    
    运行：`docker run --name test-redis -d redis`

    容器列表：`docker ps`
    
    停止容器：`docker stop test-reids`
    
    启动容器：`docker start container-name/container-id`
    
    端口映射：`docker run -d -p 6378:6379 --name port-redis redis` 映射容器的6379到本机的6378端口，因为Docker
    实际上试运行在虚拟机上，所以需要做一次端口映射
    
    删除容器：`docker rm container-id`
    
    查看当前容器日志：`docker logs container-name/container-id`    
    
- Spring Data JPA

     JPA（Java Persitence API）是一个基于O/R映射的标准规范，规范即只定义标准规则，不提供实现，主要实现由
     Hibernate、EclipseLink和OpenJpa等。
     Spring Data JPA是Spring Data的一个子项目，通过提供基于JPA的Repository极大地减少了JPA作为数据
     访问方案的代码量。
    
    - 实例
    
    (1) 启动Oracle XE
    `docker run -d -p 9090:8080 -p 1521:1521 daocloud.io/ihypo/oracle-xe-11g`
    
    管理访问界面:
    ```
    url:http://localhost:9090/apex
    workspace:internal
    username:admin
    password:oracle
    ```