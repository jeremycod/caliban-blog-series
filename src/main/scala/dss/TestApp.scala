package dss

import caliban.CalibanError.ValidationError
import caliban.GraphQL.graphQL
import caliban.RootResolver
import zio.{IO, ZIO, ZIOAppDefault}

object TestApp extends ZIOAppDefault {

  val test4: IO[ValidationError, Int] =
    for {
      dbService   <- DBService()
      resolver    = Api.resolver(dbService)
      api         = graphQL(RootResolver(resolver))
      interpreter <- api.interpreter
      _           <- interpreter.execute(Query.orders)
      dbHits      <- dbService.hits
      _           <- ZIO.debug(s"ZQuery with Batch - DB Hits: $dbHits")
    } yield 0

  override def run: IO[ValidationError, Int] =
    test4
}
