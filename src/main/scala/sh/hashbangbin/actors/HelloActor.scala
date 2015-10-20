package sh.hashbangbin.actors

import akka.actor.Props
import akka.persistence.PersistentActor
import akka.util.Timeout
import scala.concurrent.duration._

case class HelloCommand(greeting: String)
case class HelloEvent(greeting: String)

class HelloActor extends PersistentActor {
  implicit val timeout: Timeout = 5 seconds

  val ACTOR_ID = "D7EAD92F-4A0B-40AF-87C6-CEC38C7BDE2F"

  override def receiveRecover: Receive = {
    case HelloEvent(greeting) => println(s"Replay of HelloEvent(): 'greeting' property => [${greeting}]")
  }

  override def receiveCommand: Receive = {
    case HelloCommand(greeting) => persist(HelloEvent(greeting)){ event =>
      println(s"Someone just said [${event.greeting}], I'm responding and persisting their message" )
      sender() ! s"hello, ${event.greeting} !"
    }
  }

  override def persistenceId: String = ACTOR_ID
}
