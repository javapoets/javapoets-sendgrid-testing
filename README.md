# Javapoets SendGrid Testing

## Main Classes

- [SendgridSimpleExample.java](src/main/java/javapoets/sendgrid/SendgridSimpleExample.java)
= [SendgridSimpleExampleWithMailHelper.java](src/main/java/javapoets/sendgrid/SendgridSimpleExampleWithMailHelper.java)

## Environment Setup

Create a `.env` file at the root of your project with the following information.

```
SENDGRID_API_KEY=<YOUR SENDGRID API KEY>
```

## Build Instructions

```bash
$ gradle clean build run
```

## Build, Install, and Run
```bash
$ gradle clean build
$ gradle installDist
$ cd build/install/javapoets-sendgrid/bin
$ javapoets-sendgrid.bat
```

## Run using Gradle: JavaExec

### Run SendgridSimpleExample
```bash
$ gradle execute -Pmain-class=javapoets.sendgrid.SendgridSimpleExample -Pmy-args=test@example.com,test@example.com
```

### Run SendgridSimpleExampleWithMailHelper
```bash
$ gradle execute -Pmain-class=javapoets.sendgrid.SendgridSimpleExampleWithMailHelper -Pmy-args=test@example.com,test@example.com
```

## Run using Java command

### Run SendgridSimpleExample
```bash
$ java -classpath "build\install\javapoets-sendgrid-testing\lib\*" javapoets.sendgrid.SendgridSimpleExample test@example.com test@example.com
```

### Run SendgridSimpleExampleWithMailHelper
```bash
$ java -classpath "build\install\javapoets-sendgrid-testing\lib\*" javapoets.sendgrid.SendgridSimpleExampleWithMailHelper test@example.com test@example.com
```
