package $package$

import org.scalatra._
import scalate.ScalateSupport

class $servlet_name$ extends $name;format="Camel"$Stack {

  get("/") {
    <html>
      <head>
        <title>Hello World!</title>
      </head>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
}
