Author: Blade Su

This is a demo of a java project implementation with spring boot framework and cooperated with famous karfka platform.

About the docker part, kafka community seems have no official docker image. Therefore I leverage a popular docker hub repo into context_kafka to easily set up the environment. Here is the repo: https://github.com/wurstmeister/kafka-docker

## Prerequisite:
- docker
- docker-compose
- jdk 1.8 up
- gradle 5 up

## Before run the application, start the kafka service in docker:

To start the zookeeper and kafka broker server in docker as daeman. Run the following script in "context_kafka" directory.
```
docker-compose up -d
```
You should see follwoing information.
```console
➜  context_kafka git:(master) ✗ docker-compose up -d
Starting spring_boot_demo_with_kafka_zk_1 ... done
Starting spring_boot_demo_with_kafka_kafka_1 ... done
```

To close the service, please run:
```
docker-compose down
```
And you will see:
```console
Stopping spring_boot_demo_with_kafka_kafka_1 ... done
Stopping spring_boot_demo_with_kafka_zk_1    ... done
Removing spring_boot_demo_with_kafka_kafka_1 ... done
Removing spring_boot_demo_with_kafka_zk_1    ... done
Removing network spring_boot_demo_with_kafka_default
```

### Run the spring boot application:

In the console, please run the following script in the project folder.
```
gradlew bootRun
```
You should see following info:
```
BUILD SUCCESSFUL in 2s
1 actionable task: 1 executed
Starting a Gradle Daemon (subsequent builds will be faster)

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)
 .
 .
```

### Test application:

You can directly send HTTP post to the server with any tool.

Here is a example which sends messenge by "curl"
```
curl -X POST -F 'message=test' http://127.0.0.1:8080/kafka/publish
```
In above example, the post with parameter message with value "test". So if the application work properly, you will see the logger info like following one.
```
2020-07-01 08:13:19.931  INFO 62122 --- [ntainer#0-0-C-1] o.b.d.k.kafka.Consumer                   : #### -> Consumed message -> test
```
The kafka consumer shows it received message with value of "test".