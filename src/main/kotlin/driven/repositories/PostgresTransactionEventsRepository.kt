package driven.repositories

import com.github.jasync.sql.db.QueryResult
import com.github.jasync.sql.db.postgresql.PostgreSQLConnectionBuilder
import core.RegisterResult
import core.Transaction

class PostgresTransactionEventsRepository : ITransactionEventsRepository {
    override fun store(event: RegisterResult) {
        TODO("Not yet implemented")
    }

    override fun loadAllTransactions(): Collection<Transaction> {
        //

// Connection to PostgreSQL DB => make this a companion object
        val connection = PostgreSQLConnectionBuilder.createConnectionPool(
            ""
           // "jdbc:postgresql://$host:$port/$database?user=$username&password=$password"
        );
// Execute query
        val future = connection.sendPreparedStatement("select * from table");
// work with result ...
        future.thenAccept { result: QueryResult -> println(result.rows) }
// Close the connection pool
        connection.disconnect().get()

        TODO("complete this function and return a list of transactions from the database")
    }
}