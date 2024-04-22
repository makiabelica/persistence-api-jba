[Link mysql y hd](https://ufgedu-my.sharepoint.com/personal/ia_angieespinoza_ufg_edu_sv/_layouts/15/onedrive.aspx?login_hint=ia%2Eangieespinoza%40ufg%2Eedu%2Esv&sw=auth&isAscending=false&id=%2Fpersonal%2Fia%5Fangieespinoza%5Fufg%5Fedu%5Fsv%2FDocuments%2Fciclo01%2D024%2FFrameworks%2FUnidad3&sortField=Modified&view=0)


-  "Local" se refiere a que no usamos Glassfish para la conexion a la BD

-  "WAR" se refiere a que si usamos Glassfish para la conexion a la BD (Como el ejemplo que les di en video
---

### GUIA PARA HACER FUNCIONAR LO DE JAVA (CONF Glassfish) 
-------
#Antes de encender el server de glassfish.

1- Adjuntar los dos archivos .jar en que van en este mensaje en la ruta 
C:\Servers\glassfish-5.0\glassfish5\glassfish\lib

1.1 IMPORTANTE(esto solo hacerlo en la U no en sus PC) 
agregar esta linea: set AS_JAVA=C:\Program Files\Java\jdk1.8.0_202 en el archivo de la ruta: 
C:\Servers\glassfish-5.0\glassfish5\glassfish\config\asenv


# Ahora con el server encendido hacer lo siguiente:

2- En localhost:4848 ir a JDBC Connection Pools y crear uno nuevo con las siguientes configuraciones: 

 - PoolName: elquesea
 - Resource Type: javax.sql.ConnectionPoolDataSource
- Database Driver Vendor: MySql
- Classname: com.mysql.cj.jdbc.MysqlDataSource

2.1 En la seccion Addition Properties (parte de abajo)
useTimeZone: true
serverTimeZone: UTC
useSSL: false
password: contradeMysql
databaseName: nombredesuBD
serverName: localhost
datasourceName: com.mysql.cj.jdbc.MysqlDataSource
user: root
portNumber: 3306
allowPublicKeyRetrieval: true

2.2 Por ultimo finalizar y hacer ping para ver si se conecto correctamente a la BD.

3- ir ahora a JDBC Resources y crear uno nuevo con las siguietes configuraciones: 

JNDI Name: elquesea IMPORTANTE(este nombre lo pondran en archivo persistence.xml en la llave <jta-data-source>)
Pool Name: Seleccionan el que crearon anteriormente en el paso 2

3.1 dar ok y salvar 
-------

### Persistence en LOCAL
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                                 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2" >

    <persistence-unit name="EstudiantePU" transaction-type="RESOURCE_LOCAL">
        <class>Estudiante</class>
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/prueba?useSSL=false&amp;useTimezone=true&amp;serverTimezone=UTC" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="nwpw023*" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="eclipselink.logging.level.sql" value="FINE" />
            <property name="eclipselink.loggin.parameters" value="true" />
        </properties>
    </persistence-unit>
</persistence>


### Dependencias LOCAL 

    <dependencies>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>8.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>javax.persistence-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>eclipselink</artifactId>
            <version>2.7.4</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.17</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.12.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.12.0</version>
        </dependency>

    </dependencies>


### Persistence en WAR JAVA

<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
                                 http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"
             version="2.2" >

    <persistence-unit name="EstudiantePU" transaction-type="JTA">
        <jta-data-source>EstudiantePU</jta-data-source>
    </persistence-unit>

</persistence>

### dependencias para WAR JAVA

    <dependencies>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>8.0.1</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>javax.persistence-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>org.eclipse.persistence</groupId>
            <artifactId>eclipselink</artifactId>
            <version>2.7.4</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.17</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.12.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.12.0</version>
        </dependency>

    </dependencies>
