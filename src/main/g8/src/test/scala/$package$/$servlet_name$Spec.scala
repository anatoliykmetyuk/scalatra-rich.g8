package $package$

import org.scalatest._
import org.scalatest.selenium._
import org.mockito.Mockito._

class $servlet_name$Spec extends FlatSpec with Matchers with Chrome {

  markup {"""
$servlet_name$ Servlet
----------------------
This is the base servlet of the application.
"""}
  
  behavior of "$servlet_name$"

  it should "respond with code 200 on route '/'" in {
    go to "http://localhost:8080/"
    status shouldBe 200
  }

}
