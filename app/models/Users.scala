package models

import scala.concurrent.ExecutionContext.Implicits.global

import db.DbContext

case class User(id: Long, name: String, isActive: Boolean)

class Users(val db: DbContext)
{
    import db._

    val users = quote(querySchema[User]("Users"))

    def find(id: Long) =
        run(users.filter(c => c.id == lift(id) && c.isActive)).map(_.headOption)

    def create(user: User) =
        run(users.insert(lift(user)).returning(_.id)).map(newId => user.copy(id = newId))

    def delete(user: User) = run(users.filter(_.id == lift(user.id)).delete)

    def update(user: User) = run(users.filter(_.id == lift(user.id)).update(lift(user)))
}
