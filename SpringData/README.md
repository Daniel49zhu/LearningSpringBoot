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