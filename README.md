# Register-User-with-Servlet

- membuat web register dan login sederhana dengan Html Dan css, dan Java sebagai server side language (Servlet).

Dependecies
1. Mysql Connector (8.0.21)
2. javax.servlet-api (4.0.1)

How run this Src Code?
- Untuk menjalankan web Ini, packaging harus di rubah ke WAR (Web Archive), default di POM itu JAR,
- Gunakan web server Tomcat / Jetty / undertow untuk menajalankan source code Ini pada browser
- Jika Tidak ingin ribet, Gunakan Embedeed web server dengan menambahkan : 
'<build>
    <plugins>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.2</version>
        </plugin>
        <plugin>
            <groupId>org.eclipse.jetty</groupId>
            <artifactId>jetty-maven-plugin</artifactId>
            <version>9.4.14.v20181114</version>
        </plugin>
    </plugins>
  </build>
'
