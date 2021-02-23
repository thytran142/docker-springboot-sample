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

**Adding a runtime logger**

Under TourRatingController, at the beginning define the logger as below:
```
private static final Logger LOGGER =
            LoggerFactory.getLogger(TourRatingController.class);
```

Then we can log as below:
```
LOGGER.info("POST /tours/{}/ratings/{}", tourId, score);
```
There are 4 kinds of events:
1. Error
2. Warning
3. Info
4. Debug and Trace.

Error is the highest and most severe event meaning something really bad and unexpected happened. Trace is the lowest level event which may only be of interest to a developer trying to follow the logic flow.

Info and warning share the same level of severity.

_Configure the appenders and the layouts_
Refer the logback.xml file under resources folder. Each destination has its own appender and each appender could format the messages differently and for appender sent to a file.
Refer GitHub springboot/source/main/resources/org/framework/boot/logging/logback/base.xml which is a template that you can copy and define under your logback file. 

_Configure the package and the log level_
We've gonna put the log level as DEBUG.
Any events recorded at the debug level or higher are going to be logged. 

_Configure File's file appender and the logname_
We configure it under applications.properties:
```
logging.file.path=logs
logging.files=${logging.file.path}/myapp.log}
```
(Refer logs/spring.log) as an example. The logs directory is created automatically once the application is started. 
