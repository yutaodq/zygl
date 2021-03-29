/*
* https://github.com/yassineazimani/clean-architecture-pizza
 */
package mike.wolf.zygl.application.port.out;


import mike.wolf.zygl.application.exceptions.TransactionException;
import mike.wolf.zygl.application.exceptions.DatabaseException;

public interface ManagementTransaction {

    /**
     * Commence une nouvelle transaction.
     */
    void begin();

    /**
     * Commit la transaction.
     * @throws IllegalStateException
     * @throws TransactionException Si le commit échoue
     */
    void commit() throws TransactionException;

    /**
     * Annule la dernière transaction.
     * @throws IllegalStateException
     * @throws DatabaseException si erreur au niveau de la base de données
     */
    void rollback();

}// ManagementTransaction
