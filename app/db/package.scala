import io.getquill.{PostgresAsyncContext, Escape}

package object db
{
    type DbContext = PostgresAsyncContext[Escape]
}
