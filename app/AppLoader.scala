import com.typesafe.config.ConfigFactory
import controllers.UsersController
import io.getquill._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.db.Databases
import play.api.db.evolutions._
import play.api.routing.Router
import play.api.routing.sird._
import models.Users

class AppLoader extends ApplicationLoader
{
    override def load(context: Context): Application =
        new BuiltInComponentsFromContext(context)
        {
            lazy val db = new PostgresAsyncContext[Escape]("db.default")

            lazy val users = new Users(db)
            lazy val usersController = new UsersController(users)

            val router = Router.from {
                case GET(p"/users/${long(id)}") => usersController.get(id)
                case POST(p"/users") => usersController.create
                case DELETE(p"/users/${long(id)}") => usersController.delete(id)
                case PUT(p"/users/${long(id)}") => usersController.update(id)
            }

            val config = ConfigFactory.load()
            val section = "db.default."
            val hostName = config.getString(section + "host")
            val port = config.getString(section + "port")
            val userName = config.getString(section + "user")
            val password = config.getString(section + "password")
            val databaseName = config.getString(section + "database")
            Evolutions.applyEvolutions(
                Databases(
                    "org.postgresql.Driver",
                    s"jdbc:postgresql://$hostName:$port/$databaseName?user=$userName&password=$password")
            )
        }.application
}