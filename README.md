**Define the schema and default data**
Normally I will init data using ExplorecaliApplication.java class, CommandRunner and run service with some data, using repositive save functions.
Now, I don't want to write that code and I want the application init data for me:
1. Under resources > Add data.sql
2. Under resources > Add schema.sql
3. Because the data.sql I use enum such as Region.java, so I want the application 
revert it properly. I add RegionConverter.java with annotation.
   
From now on, whenever I run the application, the Spring Data will run the schema.sql, import the data.sql, and automatically convert the strings to enum. 

_SpringBoot application doesn't recognize application.properties_
I need to fix by adding the below under pom.xml:
```
<resources>
			<resource>
				<directory>resources</directory>
				<targetPath>${project.build.outputDirectory}</targetPath>
				<includes>
					<include>application.properties</include>
				</includes>
			</resource>
		</resources>
```