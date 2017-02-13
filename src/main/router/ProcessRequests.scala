package router

import akka.actor.{Actor, ActorRef, Props}
import messages._

/**
  *
  */
class ProcessRequests(storage: ActorRef) extends Actor {

  def receive = {
    case Create(v) => storage forward Create(v)
    case Update(k, v) => storage forward Update(k, v)
    case Read(k) => storage forward Read(k)
    case Delete(k) => storage forward Delete(k)
  }

}

object ProcessRequests {
  def props(storage: ActorRef) = Props(new ProcessRequests(storage))
}