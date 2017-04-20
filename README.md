# Play Framework with Quill's async-postgres example


Starter project using Play Framework 2.5 with [Quill](http://getquill.io/)

This is a conversion of Quill's [Play Framework with Quill JDBC](https://github.com/getquill/play-quill-jdbc) 
template to work with Quill's asynchronous PostgreSQL support.

This project is setup with:
* [Play Evolutions](https://www.playframework.com/documentation/2.5.x/Evolutions)
* [String Interpolating Routing DSL](https://www.playframework.com/documentation/2.5.x/ScalaSirdRouter)
* [quill-async (see quill-async section)](http://getquill.io)

## How to use this template
**Option 1**: If you have [activator](https://www.lightbend.com/community/core-tools/activator-and-sbt) installed

    activator new PROJECTNAME play-quill-async-postgres-example

**Option 2:** Just clone this repository and use it with [sbt](http://www.scala-sbt.org)
