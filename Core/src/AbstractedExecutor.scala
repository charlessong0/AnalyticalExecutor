/**
  * Created by charles on 2/6/17.
  */
abstract class AbstractedExecutor (name: String, calculationContext: String) extends Serializable {
  var successor: Option[AbstractedExecutor] = None

  def initGlobalData(): Either[Exception, Option[AbstractedExecutor]] = {
    innerInitGlobalData().fold(l => Left(l), r => Right(successor))
  }

  def innerInitGlobalData(): Either[Exception, Boolean]

  def initScenarioData(): Either[Exception, Option[AbstractedExecutor]] = {
    innerInitScenarioData().fold(l => Left(l), r => Right(successor))
  }

  def innerInitScenarioData(): Either[Exception, Boolean]

  def calculate() = {}

  def innerCalculate() = {}
}

object AbstractedExecutor {
  def create() = {}

  def apply() = {
    attemptOrError(create())
  }

  def attemptOrError[A](a: => A): Either[Exception, A] = {
    try Right(a)
    catch {
      case e: Exception => {
        Left(e)
      }
    }
  }
}