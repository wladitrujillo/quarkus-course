mvn -U io.quarkus:quarkus-maven-plugin:create \
    -DprojectGroupId=org.agoncal.course.quarkus.orm  \
    -DprojectArtifactId=artist \
    -DpackageName="org.agoncal.quarkus.jdbc" \
    -Dextensions="jdbc-mysql, quarkus-agroal"

mvn -U io.quarkus:quarkus-maven-plugin:create \
    -DprojectGroupId=org.agoncal.course.quarkus.orm  \
    -DprojectArtifactId=customer \
    -DpackageName="org.agoncal.quarkus.jpa" \
    -Dextensions="jdbc-mariadb, hibernate-orm"

mvn -U io.quarkus:quarkus-maven-plugin:create \
    -DprojectGroupId=org.agoncal.course.quarkus.orm  \
    -DprojectArtifactId=vintage-store \
    -DpackageName="org.agoncal.quarkus.panache" \
    -Dextensions="jdbc-postgresql, hibernate-orm-panache"