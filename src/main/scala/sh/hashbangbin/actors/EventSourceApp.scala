package sh.hashbangbin.actors

import akka.actor.{Props, ActorSystem}
import javax.inject._

import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object EventSourceApp extends App {
  implicit val timeout: Timeout = 5 seconds

  val system = ActorSystem.create("hashbangbin")
  val helloActor = system.actorOf(Props[HelloActor], "hello-actor")

  def hello(greeting: String) = {
    (helloActor ? HelloCommand(greeting) ).mapTo[String].map { message =>
      println(message)
    }

  }

  hello("world")

}
